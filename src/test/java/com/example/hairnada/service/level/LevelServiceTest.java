package com.example.hairnada.service.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.mapper.level.LevelMapper;
import com.example.hairnada.vo.level.LevelVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class LevelServiceTest {

    @Mock
    private LevelMapper levelMapper;

    @InjectMocks
    private LevelService levelService;
    private LevelDto levelDto;
    private LevelVo levelVo;

    @BeforeEach
    void setUp(){
        levelDto = new LevelDto();
        levelDto.setLevelNumber(1L);
        levelDto.setLevelTitle("회원 슈윳~");
        levelDto.setLevelContent("등급갑니다잇");
        levelDto.setMembershipNumber(2L);
        levelDto.setUserNumber(25L);
    }

    @Test
    void insertTier() {
//        doReturn(levelDto).when(levelMapper).insertTier(any(LevelDto.class));
//
//        LevelVo result = levelService.selectTier(3L);
//
//        assertThat(result.getUserNumber()).isEqualTo(levelDto.getUserNumber());
    }

    @Test
    void selectTier() {
    }
}