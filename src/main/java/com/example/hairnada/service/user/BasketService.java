package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.BasketDto;
import com.example.hairnada.mapper.user.BasketMapper;
import com.example.hairnada.service.store.StoreFileService;
import com.example.hairnada.vo.user.BasketVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BasketService {
    private final BasketMapper basketMapper;

    // 장바구니에서 상품 조회
    @Transactional(readOnly = true)
    public List<BasketVo> findAll(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("사용자가 존재하지 않습니다.");
        }
        return basketMapper.selectAll(userNumber);
    }

    // 장바구니에 상품 추가
    public void register(BasketDto basketDto){
        if(basketDto == null){
            throw new IllegalArgumentException("장바구니 정보가 없습니다.");
        }
        basketMapper.insert(basketDto);
    }

    // 장바구니에서 상품 삭제
    public void remove(Long basketNumber){
        if(basketNumber == null){
            throw new IllegalArgumentException("장바구니에 상품이 없습니다.");
        }
        basketMapper.delete(basketNumber);
    }

    // 30일이 지나면 자동 삭제
    public void removeAfter30(){
        basketMapper.deleteAfter30();
    }

    // 장바구니에 담간 상품 개수
    @Transactional(readOnly = true)
    public int count(Long userNumber){
        return basketMapper.count(userNumber);
    }

    // 결제 직전 상품 개수 업데이트하기
    public void modify(BasketDto basketDto){
        if(basketDto == null){
            throw new IllegalArgumentException("장바구니에 상품이 없습니다.");
        }
        basketMapper.update(basketDto);
    }
}
