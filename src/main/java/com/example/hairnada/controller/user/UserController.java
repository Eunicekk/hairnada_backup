package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.EmailService;
import com.example.hairnada.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ws.mime.MimeMessage;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.net.PasswordAuthentication;
import java.util.Properties;


@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final EmailService emailService;

    private final UserService userService;

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/join")
    public RedirectView join(UserDto userDto){
        userService.register(userDto);
        System.out.println(userDto);
        return new RedirectView("/user/login");
    }

    @PostMapping("/login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){
        try {
            Long userNumber = userService.findUserNumber(userId, userPassword).getUserNumber();
            Long memberShip = userService.findUserNumber(userId, userPassword).getMembershipNumber();
            // 로그인 성공시 세션에 담기
            req.getSession().setAttribute("userNumber" , userNumber);
            req.getSession().setAttribute("memberShip", memberShip);

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+memberShip);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+userNumber);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new RedirectView("/user/login");
        }
        return new RedirectView("/");
    }

//  계정찾기
    @GetMapping("/find-id")
    public void find(){}

   @PostMapping("/find-id")
   public RedirectView sendMail(UserDto userDto){
       emailService.sendIdPasswordEmail(userDto);
       System.out.println("메일 전송 완료");
       return new RedirectView("/user/login");
   }


//    로그아웃
    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req){
        // 세션 초기화
        req.getSession().invalidate();
        return new RedirectView("/");
    }

//    @GetMapping("/modify")
//    public void userUpdate(){}
//
//    @PostMapping("/modify")
//    public RedirectView userUpdate(HttpServletRequest req, UserDto userDto) {
//        req.getSession().getAttribute("userNumber");
//        userService.userUpdate(userDto);
//
//        return new RedirectView("/user/myPage");
//    }
}
