package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchStoreVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class StoreMapperTest {

    @Autowired
    private StoreMapper storeMapper;
    private SearchStoreVo searchStoreVo;
    private StoreDto storeDto;
    private CriteriaAdminList criteriaAdminList;

    @BeforeEach
    void setUp(){
        criteriaAdminList = new CriteriaAdminList(1, 12);
        searchStoreVo = new SearchStoreVo();
        storeDto = new StoreDto();
        storeDto.setStoreContent("test Content");
        storeDto.setStoreNumber(1L);
        storeDto.setStoreTitle("test Title");
        searchStoreVo.setStoreCategoryNumber(1L);
    }

    @Test
    void select() {
    }

    @Test
    void selectList() {
    }

    @Test
    void storeTotal() {
    }

    @Test
    void selectStoreCategory() {
    }

    @Test
    void selectStoreSearch(){
//        List<StoreVo> storeList = storeMapper.selectStoreSearch(searchStoreVo, criteriaAdminList,userNumber);
    }
}