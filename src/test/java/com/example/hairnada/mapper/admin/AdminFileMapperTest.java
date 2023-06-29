package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.hair.HairFileDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class AdminFileMapperTest {
    @Autowired
    private AdminFileMapper adminFileMapper;

    private HairFileDto hairFileDto;

    @BeforeEach
    void setUp(){
        hairFileDto = new HairFileDto();
        hairFileDto.setHairFileName("aaa");
        hairFileDto.setHairFileUuid("testUUID");
        hairFileDto.setHairFileUploadPath("/23/02/02");
        hairFileDto.setHairNumber(6L);
    }

    @Test
    void insertHairFile() {
        System.out.println(hairFileDto.toString());
        adminFileMapper.insertHairFile(hairFileDto);

        assertThat(adminFileMapper.selectHairList(hairFileDto.getHairNumber()).size())
                .isNotEqualTo(0);
    }

    @Test
    void selectHairList(){}
}