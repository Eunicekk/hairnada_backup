package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.store.BuyDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.store.BuyVo;
import com.example.hairnada.vo.user.BasketVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
    // 회원 정보 가져오기
    public UserDto selectUser(Long userNumber);

    // 장바구니에서 선택한 정보 가져오기
    public BasketVo selectBuy(Long basketNumber);

    // 구매 정보 추가하기
    public void insert(BuyDto buyDto);

    // 구매 완료되면 장바구니 삭제하기
    public void delete(Long basketNumber);

    // 구매내역 조회하기
    public List<BuyVo> selectBuyOk(Long userNumber);

    // 구매내역 필터 처리하기
    public List<BuyVo> selectBuyOkFilter(Long userNumber, Long deliveryNumber);
}
