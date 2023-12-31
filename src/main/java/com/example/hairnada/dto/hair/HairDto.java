package com.example.hairnada.dto.hair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairDto {
    private Long hairNumber;
    private String hairName;
    private Long hairLikeCnt;
    private String hairContent;
    private String hairGender;
    private Long shapeNumber;
    private Long hairShopNumber;
    private Long hairFileNumber;
    private Long lengthNumber;
}
