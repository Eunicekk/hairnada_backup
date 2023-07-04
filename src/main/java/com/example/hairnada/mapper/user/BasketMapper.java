package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.BasketDto;
import com.example.hairnada.vo.user.BasketVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasketMapper {
    // 장바구니에서 상품 조회
    public List<BasketVo> selectAll(Long userNumber);

    // 장바구니에 상품 추가
    public void insert(BasketDto basketDto);

    // 장바구니에서 상품 삭제
    public void delete(Long basketNumber);

    // 30일 지나면 자동 삭제
    public void deleteAfter30();

    // 장바구니에 담긴 상품 개수
    public int count(Long userNumber);

    // 결제 직전 상품 개수 업데이트하기
    public void update(BasketDto basketDto);
}
