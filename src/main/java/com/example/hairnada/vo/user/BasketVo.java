package com.example.hairnada.vo.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BasketVo {
    private Long basketNumber;
    private Long basketCnt;
    private Long storeNumber;
    private String StoreTitle;
    private Long storePrice;
    private Long storePriceAll;
    private Long deliveryFee;
    private Long userNumber;
    private Long storeFileNumber;
    private String storeFileName;
    private String storeFileUploadPath;
    private String storeFileUuid;
}
