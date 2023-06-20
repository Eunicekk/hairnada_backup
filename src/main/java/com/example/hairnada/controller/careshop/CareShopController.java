package com.example.hairnada.controller.careshop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/careshop/*")
@RequiredArgsConstructor
public class CareShopController {
    // list 페이지 띄우기
    @GetMapping("/list")
    public String careShopList(){
        return "careshop/careshopList";
    }

    // read 페이지 띄우기
    @GetMapping("/read")
    public String careShopRead(){
        return "careshop/careshopRead";
    }

    // write 페이지 띄우기
    @GetMapping("/write")
    public String careShopWrite(){
        return "careshop/careshopWrite";
    }
}
