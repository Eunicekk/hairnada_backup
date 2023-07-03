package com.example.hairnada.mapper.hair;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HairMapper {
    // 헤어 리스트 목록
    public List<HairVo> selectHairList(CriteriaAdminList criteriaAdminList);

    // 헤어리스트 수
    public int hairTotal();

    // 헤어 카테고리로 검색
    public List<HairDto> selectHairListByCategory(
            @Param("lengthNumber") Long lengthNumber,
            @Param("shapeNumber") Long shapeNumber,
            @Param("hairGender") String hairGender);

    // 제목으로 헤어 검색
    public List<HairDto> selectHairListByName(@Param("hairName")String hairName);

}
