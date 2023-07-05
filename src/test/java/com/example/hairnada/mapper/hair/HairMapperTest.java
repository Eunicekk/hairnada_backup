package com.example.hairnada.mapper.hair;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchHairVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class HairMapperTest {
    @Autowired
    private HairMapper hairMapper;
    private CriteriaAdminList criteriaAdminList;
    private HairVo hairVo;
    private SearchHairVo searchHairVo;

    @BeforeEach
        void setUp(){
        criteriaAdminList = new CriteriaAdminList(1,12);
        searchHairVo = new SearchHairVo();
        searchHairVo.setHairGender("M");
        searchHairVo.setShapeNumber(2L);
        searchHairVo.setLengthNumber(2L);
        searchHairVo.setKeyword("");

    }

    @Test
    void selectHairList() {
    }

    @Test
    void hairTotal() {
    }

    @Test
    void selectHairListByCategory() {
    }

    @Test
    void selectHairListByName() {
    }

    @Test
    void selectHairSearch() {
        List<HairVo> hairList = hairMapper.selectHairSearch(searchHairVo, criteriaAdminList);
        System.out.println("hairList ============" + hairList);
    }
}