package com.example.hairnada.mapper.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.level.LevelVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class LevelMapperTest {

    @Autowired
    private LevelMapper levelMapper;
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
    void selectTier() {
//        levelMapper.insertTier(levelDto);
//
//        LevelVo num = levelMapper.selectTier(levelVo.getUserNumber());
//
//        assertThat(num).isEqualTo(1);
    }
}