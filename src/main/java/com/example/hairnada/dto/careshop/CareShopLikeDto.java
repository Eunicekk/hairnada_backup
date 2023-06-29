package com.example.hairnada.dto.careshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareShopLikeDto {
    private Long careShopNumber;
    private Long userNumber;
}
