package com.example.hairnada.controller.hairshop;

import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import com.example.hairnada.service.hairshop.HairShopLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/hairshopLike/*")
@RequiredArgsConstructor
public class HairShopLikeController {
    private final HairShopLikeService hairShopLikeService;

    // 좋아요 확인
    @GetMapping("/check")
    public List<Long> checkLike(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<Long> likeList = hairShopLikeService.checkLike(userNumber);
        return likeList;
    }

    // 좋아요 추가
    @PostMapping("/add")
    public void addLike(@RequestBody HairShopLikeDto hairShopLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        hairShopLikeDto.setUserNumber(userNumber);
        hairShopLikeService.addLike(hairShopLikeDto);
    }

    // 좋아요 삭제
    @DeleteMapping("/subtract")
    public void subtractLike(@RequestBody HairShopLikeDto hairShopLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        hairShopLikeDto.setUserNumber(userNumber);
        hairShopLikeService.subtractLike(hairShopLikeDto);
    }
}
