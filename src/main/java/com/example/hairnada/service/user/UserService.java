package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;

//    회원등록
    public void register(UserDto userDto){
        if(userDto == null){
            throw new IllegalArgumentException("회원정보 누락!!!");
        }

        userMapper.join(userDto);
    }


    /**
     * 회원조회
     * @param userId
     * @param userPassword
     * @return
     * @throws IllegalArgumentException 존재하지 않는 id, pw로 조회하는 경우
     */
    @Transactional(readOnly = true)
    public Long findUserNumber(String userId, String userPassword){
        if(userId == null || userPassword == null){
            throw new IllegalArgumentException("아이디 또는 패스워드 누락");
        }

        return Optional.ofNullable(userMapper.selectUserNumber(userId, userPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 회원입니다 !!");});
    }

    /**
     * 아이디 비밀번호 조회
     * @param userName
     * @param userEmail
     * @return
     * @throws IllegalArgumentException 존재하지 않는 name, email로 조회하는 경우
     */
    public UserDto findIdPassword(String userName, String userEmail){
        if(userName == null || userEmail == null){
            throw new IllegalArgumentException("이름 또는 이메일 누락");
        }

        return Optional.ofNullable(userMapper.findUserIdPassword(userName, userEmail))
                .orElseThrow(()-> {throw new IllegalArgumentException("일치하지 않는 정보입니다!");});
    }

    @Transactional(readOnly = true)
    public int checkUserId(String userId){
        if(userId == null){
            throw new IllegalArgumentException("아이디 누락");
        }
       return userMapper.checkId(userId);
    }

    @Transactional(readOnly = true)
    public int checkUserNickname(String userNickname){
        if(userNickname == null){
            throw new IllegalArgumentException("닉네임 누락");
        }
        return userMapper.checkNickname(userNickname);
    }


}
