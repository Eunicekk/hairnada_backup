package com.example.hairnada.mapper.hairTest;

import com.example.hairnada.vo.hairTest.HairTestVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HairTestMapper {

    public List<HairTestVo> selectTestResult(@Param("shapeNumber")Long shapeNumber, @Param("hairGender")String hairGender);
}
