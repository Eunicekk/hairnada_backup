package com.example.hairnada.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BasketDto {
    private Long basketNumber;
    private Long basketCnt;
    private Long storeNumber;
    private Long userNumber;
    private String basketAddDate;
}
