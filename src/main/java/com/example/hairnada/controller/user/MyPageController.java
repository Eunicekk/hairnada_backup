package com.example.hairnada.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class MyPageController {


    @GetMapping("/myPageMain")
    public void myPageMain(){

    }

    @GetMapping("/myPage")
    public void myPage(){

    }

    @GetMapping("/myBasket")
    public void myBasket(){

    }

    @GetMapping("/myLike")
    public void myLike(){

    }

    @GetMapping("/myboard")
    public void myboard(){

    }
}
