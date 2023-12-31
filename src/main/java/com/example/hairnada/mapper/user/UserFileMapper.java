package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.UserFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {
    public void insertUserFile(UserFileDto userFileDto);

    public UserFileDto selectUserFile(Long userNumber);

    public void deleteUserFile(Long userNumber);
}
