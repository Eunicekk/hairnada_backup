package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/join")
    public RedirectView join(UserDto userDto){
        userService.register(userDto);

        return new RedirectView("/user/login");
    }


    @GetMapping("/find-id")
    public void find(){}



}
