package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import org.apache.ibatis.annotations.Mapper;

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
    public BoardVo select(Long boardNumber);

//    전체 조회
    public List<BoardVo> selectAll(Criteria03 criteria03);

//    전제 게시글 조회
    public int selectTotal();

//    제목과 내용으로 검색
    public List<BoardVo> searchByTitleAndContent(Criteria03 criteria03);
}
