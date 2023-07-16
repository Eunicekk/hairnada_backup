package com.example.hairnada.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardCategoryVo {
    Long BoardCategoryNumber;
    Long categoryCnt;
}
