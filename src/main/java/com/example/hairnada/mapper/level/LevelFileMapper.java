package com.example.hairnada.mapper.level;

import com.example.hairnada.dto.level.LevelFileDto;
import com.example.hairnada.dto.user.UserFileDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LevelFileMapper {

    public void insertFileTier(LevelFileDto levelFileDto);

    public LevelFileDto selectFileTier(Long levelNumber);

    public void deleteFileTier(Long levelNumber);
}
