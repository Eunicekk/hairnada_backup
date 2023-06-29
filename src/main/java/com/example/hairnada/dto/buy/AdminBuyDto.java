package com.example.hairnada.dto.buy;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminBuyDto {
    private Long buyNumber;
    private String userName;
    private String buyAddress;
    private String buyMsg;
    private String storeTitle;
    private String deliveryName;
    private Long deliveryNumber;
}
