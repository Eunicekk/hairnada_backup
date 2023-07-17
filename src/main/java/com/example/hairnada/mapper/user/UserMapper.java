package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.user.UserVo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapper {

//    회원가입
    public void join(UserDto userDto);

//    로그인
    public UserDto selectUserNumber(@Param("userId") String userId, @Param("userPassword") String userPassword);

//    계정찾기 smtp-> api 사용하기
//    등급신청 할 때 맴버십 넘버 보내주기
    public UserDto findUserIdPassword(UserDto userDto);

//    아이디 중복확인
    public int checkId(String userId);

//    닉네임 중복확인
    public int checkNickname(String userNickname);

//    로그인 실패
    public int loginFail(@Param("userId") String userId, @Param("userPassword") String userPassword);

//    회원정보 수정
    public void userUpdate(UserDto userDto);

//    회원정보 수정 확인
    public UserVo updateSelect(Long userNumber);

//    카카오 api
    public Long apiUserLogin(String userId);

    public void insertKakao(UserDto userDto);

    public void insertNaver(UserDto userDto);
}
