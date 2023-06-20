package com.example.hairnada.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardDto {
    private Long boardNumber;
    private String boardTitle;
    private Long boardViewCnt;
    private Long boardContent;
    private Long userNumber;
    private Long boardCategoryNumber;

}
