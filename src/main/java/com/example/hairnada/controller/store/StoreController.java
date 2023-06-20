package com.example.hairnada.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreController {

    @GetMapping("/productList")
    public void productList(){}

    @GetMapping("/productRead")
    public void productRead(){}

}
