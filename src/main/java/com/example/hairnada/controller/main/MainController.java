package com.example.hairnada.controller.main;

import com.example.hairnada.service.main.MainService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.main.RandomProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    // 메인 띄우기
    @GetMapping("/")
    public String main(Model model){
        // 헤어스타일
        List<HairVo> hairList = mainService.findHair();
        model.addAttribute("hairList", hairList);

        // 상품
        RandomProduct storeList = mainService.findStore();
        model.addAttribute("storeList", storeList);

        // 커뮤니티
        List<BoardVo> boardList = mainService.findBoard();
        model.addAttribute("boardList", boardList);

        return "index";
    }
}
