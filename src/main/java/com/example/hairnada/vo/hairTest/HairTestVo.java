package com.example.hairnada.vo.hairTest;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairTestVo {
    private Long hairNumber;
    private String hairName;
    private String hairGender;
    private Long shapeNumber;
    private String hairFileUploadPath;
    private String hairFileUuid;
    private String hairFileName;
    private String shapeName;
}
