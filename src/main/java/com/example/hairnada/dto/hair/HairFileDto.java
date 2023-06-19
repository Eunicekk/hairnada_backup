package com.example.hairnada.dto.hair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairFileDto {
    private Long hairFileNumber;
    private String hairFileName;
    private String hairFileUploadPath;
    private String hairFileUuid;
    private Long hairNumber;
}
