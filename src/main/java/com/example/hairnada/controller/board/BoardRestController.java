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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boardR/*")
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

//    카테고리로 조회
@GetMapping("/communitySearchList/{page}")
public Map<String, Object> searchBoard(SearchVo searchVo, @PathVariable("page") int page){
    System.out.println("Rest임 수고");
    System.out.println("searchVo =============" + searchVo);
    Criteria03 criteria03 = new Criteria03(page, 9);
    int total = boardService.findSearchTotal(searchVo);
    Page03Vo page03Vo = new Page03Vo(criteria03, total);
    Map<String, Object> map = new HashMap<>();
    List<BoardVo> list = boardService.findBoardList(searchVo, criteria03);
    map.put("page", page03Vo);
    map.put("boardList", list);

    return map;
}
}
