package com.example.hairnada.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MembershipDto {
    private Long MembershipNumber;
    private String MembershipName;
}
