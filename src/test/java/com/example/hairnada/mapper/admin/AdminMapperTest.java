package com.example.hairnada.mapper.admin;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Slf4j
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    void selectUserList() {
        assertThat(adminMapper.selectUserList().size())
                .isEqualTo(1);
    }
}