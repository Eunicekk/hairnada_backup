package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.BasketDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.BasketService;
import com.example.hairnada.vo.user.BasketVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myBasket/*")
@RequiredArgsConstructor
public class BasketRestController {
    private final BasketService basketService;

    // 장바구니에 담긴 상품 조회하기
    @GetMapping("/list")
    public List<BasketVo> selectAll(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<BasketVo> basketList = basketService.findAll(userNumber);

        return basketList;
    }

    // 장바구니에 상품 추가하기는 상품 페이지에서 컨트롤러 태우기

    // 장바구니에 담긴 상품의 개수 변경하기는 상품 페이지에서 컨트롤러 태우기

    // 장바구니에 담긴 상품 삭제하기
    @DeleteMapping("/remove")
    public void remove(@RequestBody Long[] basketNumbers){
        for (Long basketNumber : basketNumbers) {
            basketService.remove(basketNumber);
        }
    }

    // 30일이 지나면 자동 삭제
    @DeleteMapping("/removeAfter30")
    public void checkRemove(){
        basketService.removeAfter30();
    }

    // 장바구니에 담긴 상품 개수
    @GetMapping("/count")
    public int count(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return basketService.count(userNumber);
    }

    // 결제 직전 상품 개수 업데이트하기
    @PatchMapping("/modifyCount")
    public void modify(@RequestBody List<BasketDto> basketList){
        for(BasketDto basketDto : basketList){
            Long count = 0L;
            count = basketDto.getBasketCnt();
            System.out.println("@#@#@#" + count);
            basketService.modifyCount(basketDto);
        }
    }

}
