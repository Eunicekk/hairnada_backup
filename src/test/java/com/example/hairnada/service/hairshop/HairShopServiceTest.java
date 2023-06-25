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

        hairShopDto = new HairShopDto();
        hairShopDto.setHairShopName("헤어샵 이름이다");
        hairShopDto.setHairShopAddress("서울시 어딘가에 있다");
        hairShopDto.setHairShopContent("우리 헤어샵 소개다");
    }

    @Test
    @DisplayName("게시물 전체 조회")
    void findAll(){
        doReturn(List.of(hairShopVo)).when(hairShopMapper).selectAll(any(Criteria03.class));
        List<HairShopVo> hairShopList = hairShopService.findAll(criteria03);
        assertThat(hairShopList).contains(hairShopVo);
    }

    @Test
    @DisplayName("게시물 조회")
    void findHairShop(){
        doReturn(hairShopVo).when(hairShopMapper).select(any(Long.class));
        HairShopVo foundShop = hairShopService.findHairShop(1L);

        assertThat(foundShop).isNotNull();
        assertThatThrownBy(()->hairShopService.findHairShop(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("없습니다.");
    }

    @Test
    @DisplayName("게시물 조회 예외")
    void findHairShopException(){
        doReturn(null).when(hairShopMapper).select(any(Long.class));

        assertThatThrownBy(()->hairShopService.findHairShop(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }

    @Test
    @DisplayName("게시물 추가")
    void register(){
        doNothing().when(hairShopMapper).insert(any(HairShopDto.class));
        hairShopService.register(hairShopDto);
        verify(hairShopMapper, times(1)).insert(hairShopDto);
    }

    @Test
    @DisplayName("게시물 삭제")
    void remove(){
        // 파일 처리 구문 추가시 오류 발생
        doNothing().when(hairShopMapper).delete(any(Long.class));
        hairShopService.remove(1L);
        verify(hairShopMapper, times(1)).delete(1L);
    }

    @Test
    @DisplayName("게시물 수정")
    void modify(){
        hairShopDto.setHairShopName("수정된 헤어샵 이름");
        hairShopDto.setHairShopAddress("경기도 어딘가");
        hairShopDto.setHairShopContent("수정된 헤어샵 소개");

        doNothing().when(hairShopMapper).update(any(HairShopDto.class));
        hairShopService.modify(hairShopDto);
        verify(hairShopMapper, times(1)).update(hairShopDto);
    }
}
