package com.example.hairnada.mapper.hairshop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
class HairShopLikeMapperTest {
    @Autowired
    private HairShopLikeMapper hairShopLikeMapper;

    @Test
    void check() {
        List<Long> likeList = hairShopLikeMapper.check(1L);
        assertThat(likeList).hasSize(2);
        assertThat(likeList).isNotNull();
    }
}