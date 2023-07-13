package com.example.hairnada.controller.board;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import com.example.hairnada.service.board.BoardLikeService;
import com.example.hairnada.service.hairshop.HairShopLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/boardLike/*")
@RequiredArgsConstructor
public class BoardLikeController {
    private final BoardLikeService boardLikeService;

    // 좋아요 추가
    @PostMapping("/add")
    public void addLike(@RequestBody BoardLikeDto boardLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        boardLikeDto.setUserNumber(userNumber);
        boardLikeService.addLike(boardLikeDto);
    }

    // 좋아요 삭제
    @DeleteMapping("/subtract")
    public void subtractLike(@RequestBody BoardLikeDto boardLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        boardLikeDto.setUserNumber(userNumber);
        boardLikeService.subtractLike(boardLikeDto);
    }
}
