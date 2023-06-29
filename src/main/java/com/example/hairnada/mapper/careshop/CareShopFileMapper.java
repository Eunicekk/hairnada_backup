package com.example.hairnada.mapper.careshop;

import com.example.hairnada.dto.careshop.CareShopFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareShopFileMapper {
    // 전체 파일 조회
    public List<CareShopFileDto> selectList(Long careShopNumber);

    // 파일 삽입
    public void insert(CareShopFileDto careShopFileDto);

    // 파일 삭제
    public void delete(Long careShopNumber);
}
