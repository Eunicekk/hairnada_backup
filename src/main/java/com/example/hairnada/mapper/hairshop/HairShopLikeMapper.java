package com.example.hairnada.mapper.hairshop;

import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HairShopLikeMapper {
    // 좋아요 추가
    public void insert(HairShopLikeDto hairShopLikeDto);

    //좋아요 삭제
    public void delete(HairShopLikeDto hairShopLikeDto);
}
