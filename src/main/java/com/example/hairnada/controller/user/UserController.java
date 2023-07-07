package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ws.mime.MimeMessage;

import javax.servlet.http.HttpServletRequest;
import java.net.PasswordAuthentication;
import java.util.Properties;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {



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


//    @Value("${myapp.username}")
//    private String username;
//    @Value("${myapp.password}")
//    private String emailPassword;
//    @PostMapping("/find-id")
//    public String checkUser (Model model, UserDto userDto){
//        UserDto findUser = userService.findIdPassword(userDto);
//        model.addAttribute("user", userService.findIdPassword(userDto));
//
//        String recipientEmail = userDto.getUserEmail();
//        String userName = userDto.getUserName();
//        String userId = findUser.getUserId();
//        String userPassword = findUser.getUserPassword();
//
//        // 1. 발신자의 메일 계정과 비밀번호 설정
//        final String user = username;
//        final String password = emailPassword;
//
//        // 2. Property에 SMTP 서버 정보 설정
//        Properties prop = new Properties();
//        prop.put("mail.smtp.auth", true);
//        prop.put("mail.smtp.starttls.enable", true);
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", 587);
//
//        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
//        Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(user, password);
//                    }
//                }
//        );
//
//        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
//        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.
//
//        MimeMessage message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress(user));
//
//            // 수신자 메일 주소
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
//
//            // Subject
//            message.setSubject("assemble에서 계정 정보를 알려드립니다.");
//
//            // Text
//            String emailContent = userName + "님의 아이디와 패스워드를 알려드립니다.\n\n";
//            emailContent += "아이디: " + userId + "\n";
//            emailContent += "패스워드: " + userPassword + "\n";
//            message.setText(emailContent);
//
//            Transport.send(message);    // send message
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        return "/user/login";
//    }




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
