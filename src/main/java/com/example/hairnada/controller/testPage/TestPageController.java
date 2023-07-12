package com.example.hairnada.controller.testPage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test/*")
@RequiredArgsConstructor
public class TestPageController {

    @GetMapping("/hairNadaTest")
    public String hairNadaTest(){
        return "hairnadatest/hairNadaTest";
    }

}
