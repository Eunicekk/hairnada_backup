package com.example.hairnada.controller.level;

import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.service.level.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/level/*")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

//    등급 신청
    @GetMapping("tier")
    public void insertTier(){}

    @PostMapping("tier")
    public RedirectView insertTier(LevelDto levelDto, HttpServletRequest req, @RequestParam("levelFile")MultipartFile file) {
        HttpSession session = req.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");

        levelDto.setUserNumber(userNumber);


        levelService.insertTier(file, levelDto);
        System.out.println(levelDto);
        return new RedirectView("/user/myPage");
    }



}
