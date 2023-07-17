package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.vo.board.BoardCategoryVo;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
//    추가
    public void insert(BoardDto boardDto);

//    삭제
    public void delete(Long boardNumber);

//    수정
    public void update(BoardDto boardDto);

//    조회
    public BoardVo select(Long boardNumber, @Param("userNumber") Long userNumber);

//    전체 조회
    public List<BoardVo> selectAll(@Param("criteria") Criteria03 criteria03, @Param("userNumber")Long userNumber);

//    전제 게시글 조회
    public int selectTotal();

//    제목과 내용으로 검색
    public List<BoardVo> search(@Param("criteria")Criteria03 criteria03, @Param("search") SearchVo searchVo);

//    검색된 게시글 전체 조회
    public int searchTotal(@Param("search") SearchVo searchVo);

//    카테고리 별로 조회
    public List<BoardVo> selectCategory(@Param("boardCategoryNumber")Long boardCategoryNumber,@Param("criteria")Criteria03 criteria03);

    public List<BoardVo> selectBoardSearch(@Param("searchVo") SearchVo searchVo, @Param("criteria") Criteria03 criteria03, @Param("userNumber")Long userNumber);

    public int selectSearchTotal(SearchVo searchVo);

//    조회수 업뎃
    public void updateReadCount(Long boardNumber);


//    카테고리별 게시글 수
    public List<BoardCategoryVo> boardCount();
}
