package com.example.hairnada.dto.careshop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareShopFileDto {
    private Long careShopFileNumber;
    private String careShopFileName;
    private String careShopFileUploadPath;
    private String careShopFileUuid;
    private Long careShopNumber;
}
