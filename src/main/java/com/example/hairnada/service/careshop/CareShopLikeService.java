package com.example.hairnada.service.careshop;

import com.example.hairnada.dto.careshop.CareShopLikeDto;
import com.example.hairnada.mapper.careshop.CareShopLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareShopLikeService {
    private final CareShopLikeMapper careShopLikeMapper;

    // 좋아요 확인
    @Transactional(readOnly = true)
    public List<Long> checkLike(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(careShopLikeMapper.check(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("회원 번호가 존재하지 않습니다.");});
    }

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
