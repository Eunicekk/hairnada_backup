package com.example.hairnada.mapper.hairshop;

import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HairShopLikeMapper {
    // 좋아요 확인
    public List<Long> check(Long userNumber);

    // 좋아요 추가
    public void insert(HairShopLikeDto hairShopLikeDto);

    //좋아요 삭제
    public void delete(HairShopLikeDto hairShopLikeDto);
}
