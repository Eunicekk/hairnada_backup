package com.example.hairnada.controller.testPage;

import com.example.hairnada.service.test.TestService;
import com.example.hairnada.vo.hairTest.HairTestVo;
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
    public List<HairTestVo> hairTest(@RequestParam("resultList") List<Integer> resultList){
        List<HairTestVo> result = testService.testResult(resultList);


        System.out.println("~~~~~~~~~~~~~" + result);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + resultList);
        return result;
    }

}
