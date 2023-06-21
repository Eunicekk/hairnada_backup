package com.example.hairnada.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserDto {
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userAddress;
    private String userAddressDetail;
    private Long userStatus;
    private String userNickname;
    private String userGender;
    private String userEmail;
    private Long membershipNumber;
    private Long userFileNumber;
    private String membershipName;
}
