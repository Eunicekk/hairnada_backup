package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.user.UserMapper;
import com.example.hairnada.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailService {
//    private final JavaMailSender emailSender;
    private final UserMapper userMapper;

    @Value("${spring.mail.email}")
    private String emailSend;
    @Value("${spring.mail.password}")
    private String passwordSend;

    public void sendIdPasswordEmail(UserDto userDto) {
        UserDto findUserDto = userMapper.findUserIdPassword(userDto);

        String userEmail = findUserDto.getUserEmail();
        String userName = findUserDto.getUserName();
        String userId = findUserDto.getUserId();
        String userPassword = findUserDto.getUserPassword();

        System.out.println("@@@" + findUserDto);
        System.out.println("@@@" + findUserDto.getUserEmail());

        // 1. 발신자의 메일 계정과 비밀번호 설정
        final String senderEmail = emailSend;
        final String senderPassword = passwordSend;

        // 2. Property에 SMTP 서버 정보 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);

        // 3. SMTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(senderEmail));

            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

            // Subject
            message.setSubject("HairNada에서 계정 정보를 알려드립니다.");

            // Text
            String emailContent = userName + "님의 아이디와 패스워드를 알려드립니다.\n\n";
            emailContent += "아이디: " + userId + "\n";
            emailContent += "패스워드: " + userPassword + "\n";
            message.setText(emailContent);

            Transport.send(message);    // send message
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
