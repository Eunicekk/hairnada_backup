package com.example.hairnada.vo.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVo {
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userAddress;
    private String userReference;
    private String userPostCode;
    private String userAddressDetail;
    private Long userStatus;
    private String userNickname;
    private String userGender;
    private String userEmail;
    private Long membershipNumber;
    private Long userFileNumber;
    private String membershipName;
    private String userFileName;
    private String userFileUploadPath;
    private String userFileUuid;
}
