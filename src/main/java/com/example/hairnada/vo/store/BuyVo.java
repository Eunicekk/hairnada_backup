package com.example.hairnada.vo.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BuyVo {
    private Long buyNumber;
    private Long buyCnt;
    private String buyMsg;
    private String buyDateFormat;
    private String storeTitle;
    private Long storePrice;
    private Long userNumber;
    private Long storeNumber;
    private Long storeFileNumber;
    private String storeFileName;
    private String storeFileUploadPath;
    private String storeFileUuid;
    private Long deliveryNumber;
    private String deliveryName;
}
