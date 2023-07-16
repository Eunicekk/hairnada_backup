package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.UserService;
import com.example.hairnada.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
@Slf4j
public class UserRestController {
   private final UserService userService;
   @GetMapping("/checkId")
   public int checkUserId(String userId){
      return userService.checkUserId(userId);
   }

   @GetMapping("/checkNickname")
   public int checkUserNickname(String userNickname){
      return userService.checkUserNickname(userNickname);
   }

   @GetMapping("/loginFail")
   public int loginFail(String userId, String userPassword){
      return userService.loginFail(userId, userPassword);
   }



//   @PostMapping("/registerNaver")
//   public ResponseEntity<String> registerNaverUser(@RequestBody UserVo userVo, HttpServletRequest req) {
//      System.out.println(userVo);
//      try {
//         // 중복된 ID인 경우 에러 응답 반환
//         if (userService.checkUserId(userVo.getUserId()) > 0) {
//            // 이미 사용 중인 ID일 경우 로그인 처리
//            Long userNumber = userService.apiUserLogin(userVo);
//            req.getSession().setAttribute("userNumber", userNumber);
//            return ResponseEntity.ok("Naver login successful.");
//         }
//
//         // 서버로부터 받은 네이버 사용자 정보를 UserService를 통해 처리
//         userService.registerNaverUser(userVo);
//         req.getSession().setAttribute("userNumber", userVo.getUserNumber());
//
//         // 사용자 정보 처리 후, 필요한 응답을 반환
//         return ResponseEntity.ok("Naver registration successful. Please log in.");
//      } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Naver login information.");
//      }
//   }

   @PostMapping("/registerKakao")
   public ResponseEntity<String> registerKakaoUser(@RequestBody UserDto userDto, HttpServletRequest req) {
      try {
         // 중복된 ID인 경우 에러 응답 반환
         if (userService.checkUserId(userDto.getUserId()) > 0) {
            // 이미 사용 중인 ID일 경우 로그인 처리
            Long userNumber = userService.apiUserLogin(userDto.getUserId());
            req.getSession().setAttribute("userNumber", userNumber);
            return ResponseEntity.ok("Kakao login successful.");
         }

         // 카카오 사용자 정보를 UserService를 통해 처리
         userService.registerKakaoUser(userDto);
         req.getSession().setAttribute("userNumber", userDto.getUserNumber());

         // 사용자 정보 처리 후, 필요한 응답을 반환
         return ResponseEntity.ok("Kakao registration successful. Please log in.");
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Kakao login information.");
      }
   }

   @GetMapping("/logout")
   public RedirectView logout(HttpServletRequest request) {
      try {
         // 세션 초기화
         request.getSession().invalidate();

         // 클라이언트에서 카카오 API 정보 초기화를 위한 스크립트 실행
         String kakaoLogoutScript = "<script>\n" +
                 "    if (Kakao.isInitialized()) {\n" +
                 "        Kakao.Auth.logout(function () {\n" +
                 "            console.log('Kakao API 정보 초기화 완료');\n" +
                 "        });\n" +
                 "    }\n" +
                 "</script>";
         request.setAttribute("kakaoLogoutScript", kakaoLogoutScript);

         // 클라이언트에서 네이버 API 정보 초기화를 위한 스크립트 실행
         String naverLogoutScript = "<script>\n" +
                 "    var xhr = new XMLHttpRequest();\n" +
                 "    xhr.open('GET', 'https://nid.naver.com/nidlogin.logout');\n" +
                 "    xhr.onload = function () {\n" +
                 "        console.log('Naver API 정보 초기화 완료');\n" +
                 "    };\n" +
                 "    xhr.send();\n" +
                 "</script>";
         request.setAttribute("naverLogoutScript", naverLogoutScript);

         // 페이지 이동
         return new RedirectView("/user/myPage");
      } catch (Exception e) {
         // 오류 처리
         e.printStackTrace();
         // 오류 페이지로 이동하거나 다른 적절한 처리를 수행할 수 있습니다.
         return null;
      }
   }
}
