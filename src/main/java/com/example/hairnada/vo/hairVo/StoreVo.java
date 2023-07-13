package com.example.hairnada.vo.hairVo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreVo {
    private Long storeNumber;
    private String storeTitle;
    private Long storeViewCnt;
    private Double storeScoreAvg;
    private String storeContent;
    private Long storePrice;
    private Long storeCategoryNumber;
    private String storeCategoryName;
    private Long storeFileNumber;
    private String storeFileName;
    private String storeFileUploadPath;
    private String storeFileUuid;
    private Long userNumber;
    private String storeMainContent;
    private int likeCnt;
}
