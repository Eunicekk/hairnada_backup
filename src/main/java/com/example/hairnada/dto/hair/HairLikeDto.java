package com.example.hairnada.dto.hair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HairLikeDto {
    private Long hairNumber;
    private Long userNumber;
}
