package com.example.hairnada.controller.user;

import com.example.hairnada.service.user.BasketService;
import com.example.hairnada.vo.user.BasketVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users/*")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    // 장바구니에 담긴 상품 조회하기
    @GetMapping("/myBasket")
    public List<BasketVo> selectAll(HttpServletRequest req){
//        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        Long userNumber = 1L;
        List<BasketVo> basketList = basketService.findAll(userNumber);

        return basketList;
    }

    // 장바구니에 상품 추가하기는 상품 페이지에서 컨트롤러 태우기

    // 장바구니에 담긴 상품 삭제하기
    @DeleteMapping("/myBasket/{basketNumber}")
    public void remove(@PathVariable("basketNumber") Long basketNumber){
        basketService.remove(basketNumber);
    }
}
