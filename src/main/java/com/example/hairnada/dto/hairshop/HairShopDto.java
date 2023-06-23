package com.example.hairnada.dto.hairshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairShopDto {
    private Long hairShopNumber;
    private String hairShopAddress;
    private String hairShopPhoneNumber;
    private String hairShopName;
    private String hairShopLink;
    private String hairShopOpenTime;
    private Long hairShopFileNumber;
    private Long userNumber;
    private String hairShopContent;
}
