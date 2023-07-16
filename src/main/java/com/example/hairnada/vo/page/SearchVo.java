package com.example.hairnada.vo.page;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchVo {
    private Long boardCategoryNumber;
    private String searchType;
    private String keyword;
    private int likeCnt;
}
