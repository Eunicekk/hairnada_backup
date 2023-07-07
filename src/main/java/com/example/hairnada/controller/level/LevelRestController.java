package com.example.hairnada.controller.level;

import com.example.hairnada.service.level.LevelService;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/levels/*")
@RequiredArgsConstructor
public class LevelRestController {

    private final LevelService levelService;

    @GetMapping("myTier")
    public LevelVo selectTier(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        return levelService.selectTier(userNumber);
    }

}
