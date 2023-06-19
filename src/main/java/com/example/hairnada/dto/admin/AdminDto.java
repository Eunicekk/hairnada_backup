package com.example.hairnada.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminDto {
    private Long adminNumber;
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminEmail;
}