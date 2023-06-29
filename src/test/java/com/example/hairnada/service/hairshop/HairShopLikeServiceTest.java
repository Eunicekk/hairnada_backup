package com.example.hairnada.service.hairshop;

import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import com.example.hairnada.mapper.hairshop.HairShopLikeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class HairShopLikeServiceTest {
    @Mock
    private HairShopLikeMapper hairShopLikeMapper;

    @InjectMocks
    private HairShopLikeService hairShopLikeService;

    private HairShopLikeDto hairShopLikeDto;

    @BeforeEach
    void setUp(){
        hairShopLikeDto = new HairShopLikeDto();

        hairShopLikeDto.setHairShopNumber(160L);
        hairShopLikeDto.setUserNumber(1L);
    }

    @Test
    @DisplayName("좋아요 추가")
    void add(){
        doNothing().when(hairShopLikeMapper).insert(any(HairShopLikeDto.class));
        hairShopLikeService.addLike(hairShopLikeDto);
        verify(hairShopLikeMapper, times(1)).insert(hairShopLikeDto);
    }

    @Test
    @DisplayName("좋아요 삭제")
    void subtract(){
        doNothing().when(hairShopLikeMapper).delete(any(HairShopLikeDto.class));
        hairShopLikeService.subtractLike(hairShopLikeDto);
        verify(hairShopLikeMapper, times(1)).delete(hairShopLikeDto);
    }
}
