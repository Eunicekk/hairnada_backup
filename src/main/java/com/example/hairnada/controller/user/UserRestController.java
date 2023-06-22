package com.example.hairnada.controller.user;

import com.example.hairnada.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/checkId")
    public int checkUserId(String userId){
        return userService.checkUserId(userId);
    }

}
