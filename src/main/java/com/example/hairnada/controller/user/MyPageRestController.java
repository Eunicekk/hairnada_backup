package com.example.hairnada.controller.user;

import com.example.hairnada.service.user.UserService;
import com.example.hairnada.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myPages/*")
public class MyPageRestController {
    private final UserService userService;

    @GetMapping("/userInfo")
    public UserVo getUserInfo(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        return userService.updateSelect(userNumber);
    }

}
