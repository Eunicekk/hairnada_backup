package com.example.hairnada.mapper.board;

import com.example.hairnada.vo.board.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    전체 조회
    public List<BoardVo> selectAll();
}
