package com.example.hairnada.controller.main;

import com.example.hairnada.service.main.MainService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    private final MainRestController mainRestController;

    // 메인 띄우기
    @GetMapping("/")
    public String main(Model model){
        // 헤어스타일
        List<Integer> hairNumbers = mainRestController.mainHair();
        List<HairVo> hairList = mainService.findHair(hairNumbers);
        model.addAttribute("hairList", hairList);

        // 상품

        // 커뮤니티
        List<Integer> boardNumbers = mainRestController.mainBoard();
        List<BoardVo> boardList = mainService.findBoard(boardNumbers);
        model.addAttribute("boardList", boardList);

        return "index";
    }
}
