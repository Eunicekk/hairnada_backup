package com.example.hairnada.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardReplyDto {
    private Long boardReplyNumber;
    private String boardReplyContent;
    private String boardReplyRegisterDate;
    private String boardReplyUpdateDate;
    private Long userNumber;
    private Long boardNumber;
}
