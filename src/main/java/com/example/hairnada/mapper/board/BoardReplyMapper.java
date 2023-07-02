package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardReplyDto;
import com.example.hairnada.vo.page.Criteria03;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardReplyMapper {
    public void insert(BoardReplyDto boardReplyDto);
    public List<BoardReplyDto> selectList(Long boardNumber);
    public BoardReplyDto select(Long boardReplyNumber);
    public void update(BoardReplyDto boardReplyDto);
    public void delete(Long boardReplyNumber);
    public List<BoardReplyDto> selectListPage(@Param("criteria")Criteria03 criteria03, @Param("boardNumber") Long boardNumber);
    public int selectTotal(Long boardNumber);
}
