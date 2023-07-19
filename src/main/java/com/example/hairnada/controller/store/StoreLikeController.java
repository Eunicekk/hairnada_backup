package com.example.hairnada.controller.store;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.store.StoreLikeDto;
import com.example.hairnada.service.board.BoardLikeService;
import com.example.hairnada.service.store.StoreLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/storeLike/*")
@RequiredArgsConstructor
public class StoreLikeController {
    private final StoreLikeService storeLikeService;

    // 좋아요 추가
    @PostMapping("/add")
    public void addLike(@RequestBody StoreLikeDto storeLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        storeLikeDto.setUserNumber(userNumber);
        storeLikeService.addLike(storeLikeDto);
    }

    // 좋아요 삭제
    @DeleteMapping("/subtract")
    public void subtractLike(@RequestBody StoreLikeDto storeLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        storeLikeDto.setUserNumber(userNumber);
        storeLikeService.subtractLike(storeLikeDto);
    }

    @GetMapping("/check")
    public List<Long> checkLike(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<Long> likeList = storeLikeService.checkLike(userNumber);
        return likeList;
    }

}
