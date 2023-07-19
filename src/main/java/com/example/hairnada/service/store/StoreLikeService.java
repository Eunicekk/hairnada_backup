package com.example.hairnada.service.store;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.store.StoreLikeDto;
import com.example.hairnada.mapper.board.BoardLikeMapper;
import com.example.hairnada.mapper.store.StoreLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreLikeService {
    private final StoreLikeMapper storeLikeMapper;

    // 좋아요 추가
    public void addLike(StoreLikeDto storeLikeDto){
        if(storeLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵 정보가 없습니다.");
        }
        storeLikeMapper.insert(storeLikeDto);
    }

    // 좋아요 삭제
    public void subtractLike(StoreLikeDto storeLikeDto){
        if(storeLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵이 존재하지 않습니다.");
        }
        storeLikeMapper.delete(storeLikeDto);
    }

    @Transactional(readOnly = true)
    public List<Long> checkLike(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(storeLikeMapper.check(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("회원 번호가 존재하지 않습니다.");});
    }


}
