package com.example.hairnada.vo.level;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LevelVo {
    private Long levelNumber;
    private String levelName;
    private String levelTitle;
    private String levelContent;
    private String levelRegisterDate;
    private Long membershipNumber;
    private Long userNumber;
    private Long userFileNumber;
    private String userName;
    private String userId;
    private String membershipName;
}
