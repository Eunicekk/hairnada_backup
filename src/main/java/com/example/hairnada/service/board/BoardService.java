package com.example.hairnada.service.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.mapper.board.BoardMapper;
import com.example.hairnada.vo.board.BoardCategoryVo;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;
    private final BoardFileService boardFileService;

    //    추가
    public void register(BoardDto boardDto) {
        if (boardDto == null) {
            throw new IllegalArgumentException("게시물 정보가 없습니다.");
        }
        System.out.println(boardDto.getBoardCategoryNumber());
        boardMapper.insert(boardDto);
    }

    //    삭제
    public void remove(Long boardNumber) {
        if (boardNumber == null) {
            throw new IllegalArgumentException("존재하지 않는 게시물");
        }
        boardFileService.remove(boardNumber);
        boardMapper.delete(boardNumber);
    }

    //    수정
    public void modify(BoardDto boardDto) {
        if (boardDto == null) {
            throw new IllegalArgumentException("게시물 수정 정보가 없습니다.");
        }
        boardMapper.update(boardDto);
    }

    public void modify(BoardDto boardDto, List<MultipartFile> files) throws IOException{
        if (boardDto == null || files == null){
            throw new IllegalArgumentException("게시글 수정 매게변수 null 체크");
        }
        boardFileService.remove(boardDto.getBoardNumber());
        boardFileService.registerAndSaveFiles(files, boardDto.getBoardNumber());
        boardMapper.update(boardDto);
    }

    //    조회
    @Transactional(readOnly = true)
    public BoardVo findBoard(Long boardNumber, Long userNumber) {
        if (boardNumber == null) {
            throw new IllegalArgumentException("게시물 번호가 없습니다.");
        }
        return Optional.ofNullable(boardMapper.select(boardNumber, userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 게시물 번호");
                });
    }

    //    전체 조회
    public List<BoardVo> findAll(Criteria03 criteria03, Long userNumber) {

        return boardMapper.selectAll(criteria03, userNumber);
    }

    //    전체 게시글 조회
    @Transactional(readOnly = true)
    public int getTotal() {
        return boardMapper.selectTotal();
    }

    //    검색
    @Transactional(readOnly = true)
    public List<BoardVo> search(Criteria03 criteria03, SearchVo searchVo,Long boardNumber) {
        if (searchVo == null) {
            throw new IllegalArgumentException("입력한 키워드가 없습니다.");
        }
        return boardMapper.search(criteria03, searchVo, boardNumber);
    }

    //    전체 게시글 전체 조회
    @Transactional(readOnly = true)
    public int searchTotal(SearchVo searchVo) {
        return boardMapper.searchTotal(searchVo);
    }

    // 카테고리 별로 조회
    public List<BoardVo> selectCategory (@Param("boardCategoryNumber")Long boardCategoryNumber, @Param("criteria")Criteria03 criteria03) {
        System.out.println("service=========================" + boardCategoryNumber);
        System.out.println("+++++++++++++++++++++++" + boardMapper.selectCategory(boardCategoryNumber, criteria03));
      if (boardCategoryNumber == null){
          throw new IllegalArgumentException("카테고리 선택 정보가 없습니다.");
      }
      return Optional.ofNullable(boardMapper.selectCategory(boardCategoryNumber, criteria03))
              .orElseThrow(()->{throw new IllegalArgumentException("존재하는 게시글이 없습니다.");});
    }

//    카테고리 검색 조회
    public List<BoardVo> findBoardList(SearchVo searchVo, Criteria03 criteria03, Long userNumber){
        if (searchVo == null){
            throw new IllegalArgumentException("뭐가 없습니다.");
        }
        return boardMapper.selectBoardSearch(searchVo, criteria03, userNumber);
    }

    public int findSearchTotal(SearchVo searchVo){
        if (searchVo == null){
            throw new IllegalArgumentException("searchVo 누락!");
        }
        return boardMapper.selectSearchTotal(searchVo);
    }

    //    조회수
    public void updateViewCnt(Long boardNumber){
        if (boardNumber == null){
            throw new IllegalArgumentException("몰라요");
        }
        boardMapper.updateReadCount(boardNumber);
    }

//    댓글수
//    public int updateReplyCnt(Long boardNumber){
//        if (boardNumber == null){
//            throw new IllegalArgumentException("몰라용");
//        }
//       return boardMapper.selectReplyCnt(boardNumber);
//    }

//    카테고리별 게시글 수
    public List<BoardCategoryVo> findCategoryCnt(){
        List<BoardCategoryVo> findCategoryCnt = boardMapper.boardCount();
        return findCategoryCnt;
    }
}