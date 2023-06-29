package com.example.hairnada.service.careshop;

import com.example.hairnada.dto.careshop.CareShopLikeDto;
import com.example.hairnada.mapper.careshop.CareShopLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareShopLikeService {
    private final CareShopLikeMapper careShopLikeMapper;

    // 좋아요 추가
    public void addLike(CareShopLikeDto careShopLikeDto){
        if(careShopLikeDto == null){
            throw new IllegalArgumentException("좋아요한 케어샵 정보가 없습니다.");
        }
        careShopLikeMapper.insert(careShopLikeDto);
    }

    // 좋아요 삭제
    public void subtractLike(CareShopLikeDto careShopLikeDto){
        if(careShopLikeDto == null){
            throw new IllegalArgumentException("좋아요한 케어샵이 존재하지 않습니다.");
        }
        careShopLikeMapper.delete(careShopLikeDto);
    }
}
