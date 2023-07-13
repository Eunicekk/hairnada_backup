package com.example.hairnada.mapper.careshop;

import com.example.hairnada.dto.careshop.CareShopLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareShopLikeMapper {
    // 좋아요 확인
    public List<Long> check(Long userNumber);

    // 케어샵 좋아요 추가
    public void insert(CareShopLikeDto careShopLikeDto);

    // 케어샵 좋아요 삭제
    public void delete(CareShopLikeDto careShopLikeDto);
}
