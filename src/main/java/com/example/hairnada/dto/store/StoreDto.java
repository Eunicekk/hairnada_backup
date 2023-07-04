package com.example.hairnada.dto.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreDto {
    private Long storeNumber;
    private String storeTitle;
    private Long storeViewCnt;
    private Double storeScoreAvg;
    private String storeContent;
    private Long storePrice;
    private Long storeCategoryNumber;
    private String storeCategoryName;
    private String storeMainContent;
}
