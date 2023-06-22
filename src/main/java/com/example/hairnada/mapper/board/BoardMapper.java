package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.vo.board.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    추가
    public void insert(BoardDto boardDto);

//    조회
    public BoardVo select(Long boardNumber);

//    전체 조회
    public List<BoardVo> selectAll();
}
