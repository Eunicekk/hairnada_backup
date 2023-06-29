package com.example.hairnada.vo.hair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class HairVo {
    private Long hairNumber;
    private String hairName;
    private Long hairLikeCnt;
    private String hairContent;
    private String hairGender;
    private Long shapeNumber;
    private Long hairShopNumber;
    private Long hairFileNumber;
    private Long lengthNumber;
    private String hairFileName;
    private String hairFileUploadPath;
    private String hairFileUuid;
}
