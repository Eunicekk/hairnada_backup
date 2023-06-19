package com.example.hairnada.dto.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreFileDto {
    private Long storeFileNumber;
    private String storeFileName;
    private String storeFileUploadPath;
    private String storeFileUuid;
    private Long storeNumber;
}
