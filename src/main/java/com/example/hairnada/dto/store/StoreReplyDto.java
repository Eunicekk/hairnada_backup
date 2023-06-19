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
    private String storeRegisterDate;
    private String storeUpdateDate;
    private String storeScore;
    private Long userNumber;
    private Long storeNUmber;
}
