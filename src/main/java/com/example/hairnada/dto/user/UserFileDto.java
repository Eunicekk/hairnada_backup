package com.example.hairnada.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserFileDto {
    private Long userFileNumber;
    private String userFileName;
    private String userFileUploadPath;
    private String userFileUuid;
    private Long userNumber;
}
