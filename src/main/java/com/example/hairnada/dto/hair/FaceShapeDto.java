package com.example.hairnada.dto.hair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FaceShapeDto {
    private Long shapeNumber;
    private Long shapeName;
}
