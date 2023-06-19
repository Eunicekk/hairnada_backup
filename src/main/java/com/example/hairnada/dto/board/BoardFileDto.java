package com.example.hairnada.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardFileDto {
    private Long boardFileNumber;
    private String boardFileName;
    private String boardFileUploadPath;
    private String boardFileUuid;
    private Long boardNumber;
}
