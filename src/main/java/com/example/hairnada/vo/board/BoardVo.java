package com.example.hairnada.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardVo {
    private Long boardNumber;
    private String boardTitle;
    private Long boardViewCnt;
    private String boardContent;
    private Long userNumber;
    private Long boardCategoryNumber;
    private String userNickName;
    private String boardFileName;
    private String boardFileUploadPath;
    private String boardFileUuid;
    private String userFileName;
    private String userFileUploadPath;
    private String userFileUuid;
    private int likeCnt;
    private int replyCnt;
}