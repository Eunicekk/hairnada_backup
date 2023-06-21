package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.level.LevelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    // 회원 전체 조회
    public List<UserDto> selectUserList();

    // 등업 게시글 목록 조회
    public List<LevelVo> selectLevelList();
}
