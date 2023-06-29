package com.example.hairnada.mapper.careshop;

import com.example.hairnada.dto.careshop.CareShopFileDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
public class CareShopFileMapperTest {
    @Autowired
    private CareShopFileMapper careShopFileMapper;
    private CareShopFileDto careShopFileDto;

    @BeforeEach
    void setUp() {
        careShopFileDto = new CareShopFileDto();
        careShopFileDto.setCareShopFileName("abcd");
        careShopFileDto.setCareShopFileUuid("abcdUUID");
        careShopFileDto.setCareShopFileUploadPath("/23/06/22");
        careShopFileDto.setCareShopNumber(10L);
    }

    @Test
    void insert(){
        System.out.println(careShopFileDto);
        careShopFileMapper.insert(careShopFileDto);
        assertThat(careShopFileMapper.selectList(careShopFileDto.getCareShopNumber()).size()).isNotEqualTo(0);
    }

    @Test
    void delete(){
        careShopFileMapper.insert(careShopFileDto);
        careShopFileMapper.delete(careShopFileDto.getCareShopNumber());
        assertThat(careShopFileMapper.selectList(careShopFileDto.getCareShopNumber()).size()).isEqualTo(0);
    }

    @Test
    void selectList() {}
}
