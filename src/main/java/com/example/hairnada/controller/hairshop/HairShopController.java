package com.example.hairnada.controller.hairshop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hairshop/*")
@RequiredArgsConstructor
public class HairShopController {
    // list 페이지 띄우기
    @GetMapping("/list")
    public String hairshopList(){
        return "hairshop/styleshopList";
    }

    // read 페에지 띄우기
    @GetMapping("/read")
    public String hairshopRead(){
        return "hairshop/styleshopRead";
    }

    // write 페이지 띄우기
    @GetMapping("/write")
    public String hairshopWrite(){
        return "hairshop/styleshopWrite";
    }
}
