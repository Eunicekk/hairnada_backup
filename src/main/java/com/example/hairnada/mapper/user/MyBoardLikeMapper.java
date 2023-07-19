package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.board.BoardLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBoardLikeMapper {

    public List<Long> check(Long userNumber);

    public void insert(BoardLikeDto boardLikeDto);

    public void delete(BoardLikeDto boardLikeDto);

}
