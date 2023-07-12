package com.example.hairnada.service.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.mapper.level.LevelMapper;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class LevelService {
    private final LevelMapper levelMapper;
    private final LevelFileService levelFileService;

//    등급신청
    public void insertTier(MultipartFile file, LevelDto levelDto){
        if(levelDto == null){
            throw new IllegalArgumentException("등급처리 누락");
        }

        levelMapper.insertTier(levelDto);
        try {
            levelFileService.registerAndSaveFiles(file, levelDto.getLevelNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    등급 조회
    public LevelVo selectTier(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원번호 누락");
        }

        return levelMapper.selectTier(userNumber);
    }

}
