package com.example.hairnada.mapper.admin;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Slf4j
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    @DisplayName("회원 전체 조회")
    void selectUserList() {
        assertThat(adminMapper.selectUserList().size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("등업 신청 게시글 조회")
    void selectLevelList(){
        assertThat(adminMapper.selectLevelList().size())
                .isEqualTo(1);
    }



}