package com.example.hairnada.controller.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.service.board.BoardFileService;
import com.example.hairnada.service.board.BoardService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import com.example.hairnada.vo.page.SearchVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.aspectj.apache.bcel.generic.LocalVariableGen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardFileService boardFileService;


    @GetMapping("/communityList")
    public String communityList(Criteria03 criteria03, Model model, SearchVo searchVo){
       List<BoardVo> boardList = boardService.findAll(criteria03);
       model.addAttribute("boardList",boardList);
       model.addAttribute("pageInfo",new Page03Vo(criteria03, boardService.getTotal()));
       model.addAttribute("search", searchVo);

       return "board/communityList";
    }

    @GetMapping("/communityWrite")
    public String communityWrite(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return userNumber == null ? "/user/login" : "board/communityWrite";
    }


    @PostMapping("/communityWrite")
    public RedirectView communityWrite(BoardDto boardDto, HttpServletRequest request,
                                       RedirectAttributes redirectAttributes,
//                                       @RequestParam("boardContent") String summerNote,
                                       @RequestParam("communityFile") List<MultipartFile> files,
                                       HttpServletRequest servletRequest) {
        Long userNumber = (Long) request.getSession().getAttribute("userNumber");
        boardDto.setUserNumber(userNumber);

//        System.out.println("summerNote = " + summerNote);

        Long boardCategoryNumber = Long.parseLong(servletRequest.getParameter("boardCategoryNumber"));
        boardDto.setBoardCategoryNumber(boardCategoryNumber);

        String boardContent = boardDto.getBoardContent();
        boardDto.setBoardContent(boardContent);

        boardService.register(boardDto);
        System.out.println(boardDto);

        BoardVo boardVo = boardService.findBoard(boardDto.getBoardNumber());

        redirectAttributes.addFlashAttribute("board", boardVo);
        System.out.println(boardVo);

        if (files != null) {
            try {
                boardFileService.registerAndSaveFiles(files, boardDto.getBoardNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new RedirectView("/board/communityList");
    }


    @GetMapping("/communityRead")
    public String communityRead(Long boardNumber, Model model){
        BoardVo boardVo = boardService.findBoard(boardNumber);
        model.addAttribute("board",boardVo);
        System.out.println(boardVo);
        return "board/communityRead";
    }

    @GetMapping("/communityModify")
    public String communityModify(Long boardNumber, Model model){
        BoardVo boardVo = boardService.findBoard(boardNumber);
        model.addAttribute("board", boardVo);
        return "board/communityModify";
    }

    @PostMapping("/communityModify")
    public RedirectView communityModify(BoardDto boardDto, RedirectAttributes redirectAttributes,
                                        @RequestParam("communityFile")List<MultipartFile>files){
        try {
            boardService.modify(boardDto, files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addAttribute("boardNumber", boardDto.getBoardNumber());
        return new RedirectView("/board/communityRead");
    }

    @GetMapping("/communityRemove")
    public RedirectView communityRemove(Long boardNumber){
        boardService.remove(boardNumber);
        boardFileService.remove(boardNumber);
        return new RedirectView("/board/communityList");
    }

// 검색기능
@GetMapping("/search")
public String search(Criteria03 criteria03, Model model, SearchVo searchVo, HttpServletRequest req) {
    List<BoardVo> boardList = boardService.search(criteria03, searchVo);
    model.addAttribute("boardList", boardList);
    model.addAttribute("search", searchVo);
    model.addAttribute("pageInfo", new Page03Vo(criteria03, boardService.searchTotal(searchVo)));

    return "board/communityList";
}

}
