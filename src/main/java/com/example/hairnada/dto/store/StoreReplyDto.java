package com.example.hairnada.dto.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreReplyDto {
    private Long storeReplyNumber;
    private String storeReplyContent;
    private String storeReplyRegisterDate;
    private String storeReplyUpdateDate;
    private Long storeScore;
    private Long userNumber;
    private String userNickName;
    private Long storeNumber;
}
