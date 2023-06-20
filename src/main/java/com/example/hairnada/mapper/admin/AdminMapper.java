package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<UserDto> selectUserList();
}
