package com.example.hairnada.service.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.mapper.level.LevelMapper;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LevelService {
    private final LevelMapper levelMapper;

//    등급신청
    public void insertTier(LevelDto levelDto){
        if(levelDto == null){
            throw new IllegalArgumentException("등급처리 누락");
        }

        levelMapper.insertTier(levelDto);
    }

//    등급 조회
    public LevelVo selectTier(Long userNumber){
        if(userNumber = null){
            throw new IllegalArgumentException("회원번호 누락");
        }

        return levelMapper.selectTier(userNumber);
    }

}
