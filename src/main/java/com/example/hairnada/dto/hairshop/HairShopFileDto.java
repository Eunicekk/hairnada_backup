package com.example.hairnada.dto.hairshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairShopFileDto {
    private Long hairShopFileNumber;
    private String hairShopFileName;
    private String hairShopFileUploadPath;
    private String hairShopFileUuid;
    private Long hairShopNumber;
}
