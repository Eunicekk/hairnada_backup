package com.example.hairnada.controller.hair;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hair.HairLikeDto;
import com.example.hairnada.service.board.BoardLikeService;
import com.example.hairnada.service.hair.HairLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hairLike/*")
@RequiredArgsConstructor
public class HairLikeController {
    private final HairLikeService hairLikeService;

    // 좋아요 추가
    @PostMapping("/add")
    public void addLike(@RequestBody HairLikeDto hairLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        hairLikeDto.setUserNumber(userNumber);
        hairLikeService.addLike(hairLikeDto);
    }

    // 좋아요 삭제
    @DeleteMapping("/subtract")
    public void subtractLike(@RequestBody HairLikeDto hairLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        hairLikeDto.setUserNumber(userNumber);
        hairLikeService.subtractLike(hairLikeDto);
    }

    @GetMapping("/check")
    public List<Long> checkLike(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<Long> likeList = hairLikeService.checkLike(userNumber);
        return likeList;
    }
}
