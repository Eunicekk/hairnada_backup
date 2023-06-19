package com.example.hairnada.dto.level;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LevelFileDto {
    private Long levelFileNumber;
    private String levelFileName;
    private String levelFileUploadPath;
    private String levelFileUuid;
    private Long levelBoardNumber;
}
