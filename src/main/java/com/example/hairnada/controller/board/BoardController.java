package com.example.hairnada.controller.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/communityList")
    public void communityList(){}

    @GetMapping("/communityRead")
    public void communityRead(){}

    @GetMapping("/communityWrite")
    public void communityWrite(){}
}
