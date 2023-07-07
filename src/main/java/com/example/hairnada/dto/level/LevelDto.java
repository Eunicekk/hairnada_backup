package com.example.hairnada.dto.level;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LevelDto {
    private Long levelNumber;
    private String levelTitle;
    private String levelContent;
    private String levelRegisterDate;
    private Long membershipNumber;
    private Long userNumber;
}
