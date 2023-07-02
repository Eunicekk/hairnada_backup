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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boardR/*")
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

//    카테고리로 조회
    @GetMapping("communityList")
    public List<BoardVo> selectCategory(@Param("boardCategoryNumber") Long boardCategoryNumber,@Param("criteria")Criteria03 criteria03){
        System.out.println("카테고리 넘버 ==================== " + boardCategoryNumber);
        List<BoardVo> response = boardService.selectCategory(boardCategoryNumber, criteria03);
        System.out.println("이거야++++++++++++++" +  response);
        return response;
    }

}
