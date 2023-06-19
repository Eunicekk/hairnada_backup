package com.example.hairnada.dto.level;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LevelDto {
    Long levelBoardNumber;
    String levelBoardName;
    String levelBoardContent;
    String levelBoardRegisterDate;
    Long MembershipNumber;
    Long userNumber;
    Long userFileNumber;
}
