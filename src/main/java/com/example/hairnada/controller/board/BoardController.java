package com.example.hairnada.controller.board;

import com.example.hairnada.service.board.BoardService;
import com.example.hairnada.vo.board.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/communityList")
    public String communityList(Model model){
       List<BoardVo> boardList = boardService.findAll();
       model.addAttribute("boardList",boardList);

       return "board/communityList";
    }

    @GetMapping("/communityRead")
    public void communityRead(){}

    @GetMapping("/communityWrite")
    public void communityWrite(){}
}
