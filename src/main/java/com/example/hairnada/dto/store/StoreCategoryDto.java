package com.example.hairnada.dto.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreCategoryDto {
    private Long storeCategoryNumber;
    private String storeCategoryName;
}
