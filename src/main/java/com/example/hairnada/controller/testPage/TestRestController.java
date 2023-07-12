package com.example.hairnada.controller.testPage;

import com.example.hairnada.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tests/*")
public class TestRestController {

    private final TestService testService;

    @GetMapping("/hairTest")
    public String hairTest(@RequestParam("resultList") List<Integer> resultList){
        System.out.println(resultList);
        return "안녕";
    }

}
