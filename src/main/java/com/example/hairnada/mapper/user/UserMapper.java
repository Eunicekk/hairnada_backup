package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

//    회원가입
    public void join(UserDto userDto);

//    로그인
    public void selectUserNumber(@Param("userId") String userId, @Param("userPassword") String userPassword);

//    계정찾기 smtp-> api 사용하기
}
