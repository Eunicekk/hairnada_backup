package com.example.hairnada.controller.admin;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.admin.AdminService;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminR/*")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    // 등업 요청 수락
    @PostMapping("/membership")
    public void acceptQuest(Long userNumber, Long membershipNumber){
        adminService.acceptQuest(userNumber, membershipNumber);
    }

}
