package com.example.hairnada.mapper.careshop;

import com.example.hairnada.dto.careshop.CareShopDto;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
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
public class CareShopMapperTest {
    @Autowired
    private CareShopMapper careShopMapper;
    @Autowired
    private Criteria03 criteria03;
    private CareShopDto careShopDto;

    @BeforeEach
    void setUp(){
        careShopDto = new CareShopDto();
        careShopDto.setCareShopAddress("서울 어딘가");
        careShopDto.setCareShopName("케어샵");
        careShopDto.setCareShopOpenTime("오진 9시");
        careShopDto.setCareShopPhoneNumber("01012341234");
        careShopDto.setCareShopLink("www.aaa.co.kr");
        careShopDto.setCareShopContent("케어샵 내용");
        careShopDto.setUserNumber(3L);
        careShopMapper.insert(careShopDto);
    }

    @Test
    void selectAll(){
        List<CareShopVo> result = careShopMapper.selectAll(criteria03);
        assertThat(result).isNotNull(); // 결과가 null이 아닌지 확인합니다.
        assertThat(result).hasSizeGreaterThan(0); // 결과 리스트의 크기가 0보다 큰지 확인합니다.
    }

    @Test
    void selectTotal(){
        int size = careShopMapper.selectTotal();
        assertThat(size).isEqualTo(161);
    }

    @Test
    void select(){}

    @Test
    void insert(){}

    @Test
    void delete(){
        careShopMapper.delete(careShopDto.getCareShopNumber());
        assertThat(careShopMapper.select(careShopDto.getCareShopNumber())).isNull();
    }

    @Test
    void upadate(){
        careShopDto.setCareShopName("변경된 케어샵 이름");
        careShopDto.setCareShopAddress("경기도 어딘가");
        careShopMapper.update(careShopDto);
        assertThat(careShopMapper.select(careShopDto.getCareShopNumber()).getCareShopName())
                .isEqualTo(careShopDto.getCareShopName());
    }

    @Test
    void search(){
        SearchVo result = new SearchVo();
        result.setSearchType("title");
        result.setKeyword("케어");
        assertThat(careShopMapper.search(criteria03, result)).isNotNull();
        assertThat(careShopMapper.search(criteria03, result)).hasSizeGreaterThan(0);
    }

    @Test
    void searchTotal(){
        SearchVo result = new SearchVo();
        result.setSearchType("title");
        result.setKeyword("케어");
        int size = careShopMapper.searchTotal(result);
        assertThat(size).isEqualTo(1);
    }
}
