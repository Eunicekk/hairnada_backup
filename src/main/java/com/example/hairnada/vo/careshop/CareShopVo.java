package com.example.hairnada.vo.careshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareShopVo {
    private Long careShopNumber;
    private String careShopAddress;
    private String careShopPhoneNumber;
    private String careShopName;
    private String careShopLink;
    private String careShopOpenTime;
    private Long careShopFileNumber;
    private String careShopFileName;
    private String careShopFileUploadPath;
    private String careShopFileUuid;
    private Long userNumber;
    private Long memberShipNumber;
    private String careShopContent;
}
