package com.example.hairnada.service.store;

import com.example.hairnada.dto.store.BuyDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.store.BuyMapper;
import com.example.hairnada.vo.user.BasketVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyService {
    private final BuyMapper buyMapper;

    // 회원 정보 조회하기
    @Transactional(readOnly = true)
    public UserDto findUser(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(buyMapper.selectUser(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원 정보입니다.");});
    }

    // 장바구니에서 선택한 상품 가져오기
    @Transactional(readOnly = true)
    public BasketVo findBuy(Long basketNumber) {
        if (basketNumber == null) {
            throw new IllegalArgumentException("선택된 장바구니가 없습니다.");
        }
        return Optional.ofNullable(buyMapper.selectBuy(basketNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 장바구니 정보입니다.");});
    }

    // 구매 정보 추가하기
    public void register(BuyDto buyDto){
        if(buyDto == null){
            throw new IllegalArgumentException("구매 상품 정보가 없습니다.");
        }
        buyMapper.insert(buyDto);
    }

    // 구매가 완료되면 장바구니에서 삭제하기
    public void remove(Long basketNumber){
        if(basketNumber == null){
            throw new IllegalArgumentException("장바구니 번호가 없습니다.");
        }
        buyMapper.delete(basketNumber);
    }
}
