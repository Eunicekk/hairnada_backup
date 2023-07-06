package com.example.hairnada.mapper.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.level.LevelVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LevelMapper {

//    등급신청
    public void insertTier(LevelDto levelDto);

    public LevelVo selectTier(Long userNumber);
}
