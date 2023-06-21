package com.example.hairnada.service.hairshop;

import com.example.hairnada.dto.hairshop.HairShopDto;
import com.example.hairnada.mapper.hairshop.HairShopMapper;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class HairShopServiceTest {
    @Mock
    private HairShopMapper hairShopMapper;

    @InjectMocks
    private HairShopService hairShopService;
    
    private HairShopVo hairShopVo;
    private Criteria03 criteria03;
    private HairShopDto hairShopDto;

    @BeforeEach
    void setUp(){
        hairShopVo = new HairShopVo();
        criteria03 = new Criteria03();
    }

    @Test
    @DisplayName("게시물 전체 조회")
    void findAll(){
//        List<HairShopVo> list = hairShopMapper.selectAll(criteria03);
//        assertThat(list).isNotNull();
//        List<HairShopVo> list = hairShopService.findAll(criteria03);
//        assertThat(list).isNotNull();
        System.out.println(hairShopVo);
        System.out.println(List.of(hairShopVo));
        doReturn(List.of(hairShopVo)).when(hairShopMapper).selectAll(any(Criteria03.class));
        List<HairShopVo> hairShopList = hairShopService.findAll(criteria03);
        assertThat(hairShopList).contains(hairShopVo);
    }
}
