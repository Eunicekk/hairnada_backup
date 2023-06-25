package com.example.hairnada.mapper.hairshop;

import com.example.hairnada.dto.hairshop.HairShopDto;
import com.example.hairnada.dto.hairshop.HairShopFileDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class HairShopFileMapperTest {
    @Autowired
    private HairShopFileMapper hairShopFileMapper;
    private HairShopFileDto hairShopFileDto;

    @BeforeEach
    void setUp() {
        hairShopFileDto = new HairShopFileDto();
        hairShopFileDto.setHairShopFileName("abcd");
        hairShopFileDto.setHairShopFileUuid("abcdUUID");
        hairShopFileDto.setHairShopFileUploadPath("/23/06/22");
        hairShopFileDto.setHairShopNumber(10L);
    }

    @Test
    void insert(){
        System.out.println(hairShopFileDto);
        hairShopFileMapper.insert(hairShopFileDto);
        assertThat(hairShopFileMapper.selectList(hairShopFileDto.getHairShopNumber()).size()).isNotEqualTo(0);
    }

    @Test
    void delete(){
        hairShopFileMapper.insert(hairShopFileDto);
        hairShopFileMapper.delete(hairShopFileDto.getHairShopNumber());
        assertThat(hairShopFileMapper.selectList(hairShopFileDto.getHairShopNumber()).size()).isEqualTo(0);
    }

    @Test
    void selectList() {}
}