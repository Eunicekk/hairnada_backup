package com.example.hairnada.service.hair;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hair.HairLikeDto;
import com.example.hairnada.mapper.board.BoardLikeMapper;
import com.example.hairnada.mapper.hair.HairLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HairLikeService {
    private final HairLikeMapper hairLikeMapper;

    // 좋아요 추가
    public void addLike(HairLikeDto hairLikeDto){
        if(hairLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵 정보가 없습니다.");
        }
        hairLikeMapper.insert(hairLikeDto);
    }

    // 좋아요 삭제
    public void subtractLike(HairLikeDto hairLikeDto){
        if(hairLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵이 존재하지 않습니다.");
        }
        hairLikeMapper.delete(hairLikeDto);
    }

    @Transactional(readOnly = true)
    public List<Long> checkLike(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(hairLikeMapper.check(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("회원 번호가 존재하지 않습니다.");});
    }
}
