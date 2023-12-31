package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.user.UserMapper;
import com.example.hairnada.service.user.UserFileService;
import com.example.hairnada.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final UserFileService userFileService;

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
    public UserDto findUserNumber(String userId, String userPassword){
        if(userId == null || userPassword == null){
            throw new IllegalArgumentException("아이디 또는 패스워드 누락");
        }

        return Optional.ofNullable(userMapper.selectUserNumber(userId, userPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 회원입니다 !!");});
    }

//    /**
//     * 아이디 비밀번호 조회
//     * @param userName
//     * @param userEmail
//     * @return
//     * @throws IllegalArgumentException 존재하지 않는 name, email로 조회하는 경우
//     */
//    public UserDto findIdPassword(UserDto userDto){
//        if(userDto.getUserId() == null || userDto.getUserPassword() == null){
//            throw new IllegalArgumentException("이름 또는 이메일 누락");
//        }
//
//        return Optional.ofNullable(userMapper.findUserIdPassword(userDto))
//                .orElseThrow(()-> {throw new IllegalArgumentException("일치하지 않는 정보입니다!");});
//    }

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

    @Transactional(readOnly = true)
    public int loginFail(String userId, String userPassword){
        if(userId == null){
            throw new IllegalArgumentException("아이디 누락");
        }else if(userPassword == null){
            throw new IllegalArgumentException("비밀번호 누락");
        }
        return userMapper.loginFail(userId, userPassword);
    }

    //    회원정보 수정
    public void userUpdate(UserDto userDto, MultipartFile multipartFile){
        if(userDto.getUserNumber() == null){
            throw new IllegalArgumentException("회원번호 누락");
        }else if(userDto == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        userMapper.userUpdate(userDto);
        if(multipartFile == null || multipartFile.isEmpty()){return;}
        userFileService.remove(userDto.getUserNumber());
        try {
            userFileService.registerAndSaveFiles(multipartFile, userDto.getUserNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //    회원정보 수정 확인
    public UserVo updateSelect(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원번호 누락");
        }

        return userMapper.updateSelect(userNumber);
    }


//    로그인 api
    public Long apiUserLogin(String userId){
        if(userId == null){
            throw new IllegalArgumentException("회원 아이디 누락");
        }

        return userMapper.apiUserLogin(userId);
    }

//    로그인 api
public void registerKakaoUser(UserDto userDto) {
    if (userDto == null) {
        throw new IllegalArgumentException("카카오 회원 정보가 없습니다.");
    }

    // 중복된 ID인 경우 로그인 처리
    if (checkUserId(userDto.getUserId()) > 0) {

        apiUserLogin(userDto.getUserId());
        return;
    }

    // 받은 사용자 정보를 처리하는 로직을 구현
    System.out.println("Received Kakao user information:");
    System.out.println("Email: " + userDto.getUserEmail());
    System.out.println("ID: " + userDto.getUserId());
    System.out.println("Gender: " + userDto.getUserGender());
    System.out.println("Nickname: " + userDto.getUserName());

    // 사용자 정보 처리 후, 로직을 수행하거나 응답을 반환
    try {
        userMapper.insertKakao(userDto);
    } catch (Exception e) {
        throw new IllegalArgumentException("Failed to process Kakao login information.");
    }
}


    // 네이버 회원 등록
    public void registerNaverUser(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("네이버 회원 정보가 없습니다.");
        }

        // 중복된 ID인 경우 로그인 처리
        if (checkUserId(userDto.getUserId()) > 0) {
            apiUserLogin(userDto.getUserId());
            return;
        }

        // 서버로부터 받은 네이버 사용자 정보를 UserService를 통해 처리
        System.out.println("Received Naver User Info:");
        System.out.println("ID: " + userDto.getUserId());
        System.out.println("Name: " + userDto.getUserName());
        System.out.println("Email: " + userDto.getUserEmail());
        System.out.println("Mobile: " + userDto.getUserPhoneNumber());
        System.out.println("Gender: " + userDto.getUserGender());

        // 사용자 정보 처리 후, 로직을 수행하거나 응답을 반환
        try {
            userMapper.insertNaver(userDto);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to process Naver login information.");
        }
    }



}
