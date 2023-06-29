package com.example.hairnada.dto.hairshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairShopLikeDto {
    private Long hairShopNumber;
    private Long userNumber;
}
