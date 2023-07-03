package com.example.hairnada.vo.page;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class SearchHairVo {
    private String hairGender;
    private Long shapeNumber;
    private Long lengthNumber;
    private String keyword;
}
