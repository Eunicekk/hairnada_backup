package com.example.hairnada.mapper.user;

import com.example.hairnada.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
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
    @DisplayName("회원저장, 회원조회")
    void join() {
        userMapper.join(userDto);

        UserDto num = userMapper.selectUserNumber(userDto.getUserId(), userDto.getUserPassword());
        UserDto memberShip = userMapper.selectUserNumber(userDto.getUserId(), userDto.getUserPassword());

        assertThat(userDto.getUserNumber()).isEqualTo(num);
    }

    @Test
    @DisplayName("아이디 비밀번호 조회")
    void findUserIdPassword() {
        userMapper.join(userDto);

        UserDto user = userMapper.findUserIdPassword(userDto.getUserName(), userDto.getUserEmail());


        assertThat(userDto.getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void checkId() {
        userMapper.join(userDto);

        int cnt = userMapper.checkId(userDto.getUserId());

        assertThat(cnt).isEqualTo(1L);
    }

    @Test
    void userUpdate() {
//        userMapper.join(userDto);
//
//        UserDto user = userMapper.userUpdate(userDto.getUserNumber());
//
//        assertThat(userDto.getUserPassword()).isEqualTo(user.getUserPassword());

    }
}