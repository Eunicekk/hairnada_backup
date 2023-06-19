package com.example.hairnada.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardCategoryDto {
    private Long boardCategoryNumber;
    private String boardCategoryName;
}
