package com.example.hairnada.mapper.hairshop;

import com.example.hairnada.dto.hairshop.HairShopFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HairShopFileMapper {
    // 전체 파일 조회
    public List<HairShopFileDto> selectList(Long hairShopNumber);

    // 파일 삽입
    public void insert(HairShopFileDto hairShopFileDto);
}
