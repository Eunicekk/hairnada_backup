package com.example.hairnada.mapper.hair;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchHairVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HairMapper {

    // 조회
    public HairVo select(Long hairNumber, @Param("userNumber") Long userNumber);

    // 헤어 리스트 목록
    public List<HairVo> selectHairList(@Param("criteria") CriteriaAdminList criteriaAdminList, @Param("userNumber") Long userNumber);

    // 헤어리스트 수
    public int hairTotal();

    // 헤어 카테고리로 검색
    public List<HairDto> selectHairListByCategory(
            @Param("lengthNumber") Long lengthNumber,
            @Param("shapeNumber") Long shapeNumber,
            @Param("hairGender") String hairGender);

    // 제목으로 헤어 검색
    public List<HairDto> selectHairListByName(@Param("hairName")String hairName);


    public List<HairVo> selectHairSearch(@Param("searchHairVo") SearchHairVo searchHairVo, @Param("criteria") CriteriaAdminList criteriaAdminList);

    public int selectSearchTotal(SearchHairVo searchHairVo);

    public int likeTotal(Long hairNumber);

}
