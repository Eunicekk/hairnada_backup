package com.example.hairnada.mapper.hair;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hair.HairLikeDto;
import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HairLikeMapper {
    // 좋아요 추가
    public void insert(HairLikeDto hairLikeDto);

    //좋아요 삭제
    public void delete(HairLikeDto hairLikeDto);
}
