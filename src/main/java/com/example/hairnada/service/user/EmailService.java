//package com.example.hairnada.service.user;
//
//import com.example.hairnada.dto.user.UserDto;
//import com.example.hairnada.mapper.user.UserMapper;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//    private final JavaMailSender emailSender;
//    private final UserMapper userMapper;
//
//    @Value("${spring.mail.username}")
//    private String emailSenderAddress;
//
//    public void sendIdPasswordEmail(UserDto userDto) {
//        try {
//            MimeMessage message = createIdPasswordMessage(userDto);
//            emailSender.send(message);
//        } catch (MessagingException e) {
//            // 예외 처리
//            e.printStackTrace();
//        }
//    }
//
//    private MimeMessage createIdPasswordMessage(UserDto userDto) throws MessagingException {
//
//        UserDto user = userMapper.findUserIdPassword(userDto);
//
//        String recipientEmail = user.getUserEmail();
//        String userName = user.getUserName();
//        String userId = user.getUserId();
//        String userPassword = user.getUserPassword();
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + recipientEmail);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + userName);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + userId);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + userPassword);
//
//        String title = "Hairnada에서 계정 정보를 알려드립니다.";
//        String content = userName + "님의 아이디와 비밀번호를 알려드립니다.<br><br>";
//        content += "아이디: " + userId + "<br>";
//        content += "비밀번호: " + userPassword + "<br>";
//
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setFrom(emailSenderAddress);
//        helper.setTo(recipientEmail);
//        helper.setSubject(title);
//        helper.setText(content, true);
//
//        return message;
//    }
//}
