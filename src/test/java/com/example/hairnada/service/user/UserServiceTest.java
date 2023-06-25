package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;
    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setUserId("aaa");
        userDto.setUserPassword("1234");
        userDto.setUserName("신짱구");
        userDto.setUserNickname("짱구");
        userDto.setUserGender("M");
        userDto.setUserPhoneNumber("010-1111-1111");
        userDto.setUserEmail("asd1234@naver.vom");
        userDto.setUserAddress("강남구");
        userDto.setUserAddressDetail("103동 101호");
    }

    @Test
    @DisplayName("회원추가")
    void register() {
        doNothing().when(userMapper).join(any(UserDto.class));

        userService.register(userDto);

        verify(userMapper, times(1)).join(userDto);
    }

    @Test
    @DisplayName("회원정보 조회")
    void findUserNumber() {
        doReturn(1L).when(userMapper).selectUserNumber(any(String.class), any(String.class));

        Long num = userService.findUserNumber("test", "1234");

        assertThat(num).isEqualTo(1L);
    }

    @Test
    @DisplayName("아이디 비밀번호 조회")
    void findIdPassword() {
        doReturn(userDto).when(userMapper).findUserIdPassword(any(String.class), any(String.class));

        UserDto user = userService.findIdPassword("신짱구", "asd@asd");

        assertThat(user.getUserId()).isEqualTo(userDto.getUserId());
    }

    @Test
    @DisplayName("아이디 중복검사")
    void checkUserId() {
        doReturn(1).when(userMapper).checkId(any(String.class));

        int result = userService.checkUserId("test");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("닉네임 중복검사")
    void checkUserNickname(){
        doReturn(1).when(userMapper).checkNickname(any(String.class));

        int result = userService.checkUserNickname("test");

        assertThat(result).isEqualTo(1);
    }

}