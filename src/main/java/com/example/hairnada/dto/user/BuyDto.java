package com.example.hairnada.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BuyDto {
    private Long buyNumber;
    private String buyAddress;
    private String buyAddressDetail;
    private Long buyCnt;
    private String buyDate;
    private String buyPhoneNumber;
    private String buyName;
    private String buyMsg;
    private Long userNumber;
    private Long storeNumber;
    private Long deliveryNumber;
}
