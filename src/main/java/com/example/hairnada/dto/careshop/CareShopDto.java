package com.example.hairnada.dto.careshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareShopDto {
    private Long careShopNumber;
    private String careShopAddress;
    private String careShopAddressDetail;
    private String careShopPhoneNumber;
    private String careShopName;
    private String careShopLink;
}
