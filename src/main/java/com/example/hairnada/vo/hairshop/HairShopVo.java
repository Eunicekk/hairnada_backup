package com.example.hairnada.vo.hairshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairShopVo {
    private Long hairShopNumber;
    private String hairShopAddress;
    private String hairShopPhoneNumber;
    private String hairShopName;
    private String hairShopLink;
    private String hairShopOpenTime;
    private Long hairShopFileNumber;
    private String hairShopFileName;
    private String hairShopFileUploadPath;
    private String hairShopFileUuid;
}
