package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.BasketDto;
import com.example.hairnada.vo.user.BasketVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
public class BasketMapperTest {
    @Autowired
    private BasketMapper basketMapper;
    private BasketDto basketDto;
    private BasketVo basketVo;

    @BeforeEach
    void setUp(){
        basketDto = new BasketDto();
        basketDto.setBasketNumber(1L);
        basketDto.setBasketCnt(1L);
        basketDto.setStoreNumber(1L);
        basketDto.setUserNumber(1L);
        basketMapper.insert(basketDto);
    }

    @Test
    void selectAll(){
        List<BasketVo> result = basketMapper.selectAll(1L);
        assertThat(result).isNotNull();
        assertThat(result).hasSizeGreaterThan(0);
    }

    @Test
    void insert(){}

    @Test
    void delete(){
        basketMapper.delete(basketDto.getBasketNumber());
        assertThat(basketMapper.selectAll(1L).size()).isEqualTo(0);
    }
}
