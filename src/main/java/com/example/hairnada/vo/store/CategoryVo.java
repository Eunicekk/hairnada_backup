package com.example.hairnada.vo.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryVo {
    Long storeCategoryNumber;
    Long categoryCnt;
}
