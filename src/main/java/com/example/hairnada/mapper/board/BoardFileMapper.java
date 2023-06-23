package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileMapper {
    public void insert(BoardFileDto boardFileDto);
    public void delete(Long boardNumber);
    public List<BoardFileDto> selectList(Long boardNumber);
}
