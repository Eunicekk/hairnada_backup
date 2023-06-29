package com.example.hairnada.service.careshop;

import com.example.hairnada.dto.careshop.CareShopDto;
import com.example.hairnada.mapper.careshop.CareShopMapper;
import com.example.hairnada.vo.page.SearchVo;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.page.Criteria03;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class CareShopServiceTest {
    @Mock
    private CareShopMapper careShopMapper;

    @InjectMocks
    private CareShopService careShopService;

    private CareShopVo careShopVo;
    private Criteria03 criteria03;
    private CareShopDto careShopDto;
    private SearchVo searchVo;

    @BeforeEach
    void setUp(){
        careShopVo = new CareShopVo();
        criteria03 = new Criteria03();

        careShopDto = new CareShopDto();
        careShopDto.setCareShopName("케어샵 이름이다");
        careShopDto.setCareShopAddress("서울시 어딘가에 있다");
        careShopDto.setCareShopContent("우리 케어샵 소개다");

        searchVo = new SearchVo();
        searchVo.setSearchType("title");
        searchVo.setKeyword("강남");
    }

    @Test
    @DisplayName("게시물 전체 조회")
    void findAll(){
        doReturn(List.of(careShopVo)).when(careShopMapper).selectAll(any(Criteria03.class));
        List<CareShopVo> careShopList = careShopService.findAll(criteria03);
        assertThat(careShopList).contains(careShopVo);
    }

    @Test
    @DisplayName("게시물 조회")
    void findCareShop(){
        doReturn(careShopVo).when(careShopMapper).select(any(Long.class));
        CareShopVo foundShop = careShopService.findCareShop(1L);

        assertThat(foundShop).isNotNull();
        assertThatThrownBy(()->careShopService.findCareShop(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("없습니다.");
    }

    @Test
    @DisplayName("게시물 조회 예외")
    void findCareShopException(){
        doReturn(null).when(careShopMapper).select(any(Long.class));

        assertThatThrownBy(()->careShopService.findCareShop(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }

    @Test
    @DisplayName("게시물 추가")
    void register(){
        doNothing().when(careShopMapper).insert(any(CareShopDto.class));
        careShopService.register(careShopDto);
        verify(careShopMapper, times(1)).insert(careShopDto);
    }

    @Test
    @DisplayName("게시물 삭제")
    void remove(){
        // 파일 처리 구문 추가시 오류 발생
        doNothing().when(careShopMapper).delete(any(Long.class));
        careShopService.remove(1L);
        verify(careShopMapper, times(1)).delete(1L);
    }

    @Test
    @DisplayName("게시물 수정")
    void modify(){
        careShopDto.setCareShopName("수정된 케어샵 이름");
        careShopDto.setCareShopAddress("경기도 어딘가");
        careShopDto.setCareShopContent("수정된 케어샵 소개");

        doNothing().when(careShopMapper).update(any(CareShopDto.class));
        careShopService.modify(careShopDto);
        verify(careShopMapper, times(1)).update(careShopDto);
    }

    @Test
    @DisplayName("게시물 검색")
    void search(){
        doReturn(List.of(careShopVo)).when(careShopMapper).search(any(Criteria03.class), any(SearchVo.class));
        List<CareShopVo> careShopList = careShopService.search(criteria03, searchVo);
        assertThat(careShopList).contains(careShopVo);
    }

}
