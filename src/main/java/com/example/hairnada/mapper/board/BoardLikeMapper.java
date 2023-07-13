package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardLikeMapper {
    // 좋아요 추가
    public void insert(BoardLikeDto boardLikeDto);

    //좋아요 삭제
    public void delete(BoardLikeDto boardLikeDto);
}
