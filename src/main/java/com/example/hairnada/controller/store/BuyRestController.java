package com.example.hairnada.controller.store;

import com.example.hairnada.dto.store.BuyDto;
import com.example.hairnada.service.store.BuyService;
import com.example.hairnada.vo.store.BuyVo;
import com.example.hairnada.vo.user.BasketVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stores/*")
@RequiredArgsConstructor
public class BuyRestController {
    private final BuyService buyService;
    private List<BasketVo> basketList;

    // 구매할 상품 띄우기
    @PostMapping("/buy")
    public List<BasketVo> buy(@RequestBody Long[] basketNumbers){
        basketList = new ArrayList<>();

        for(Long basketNumber : basketNumbers){
            BasketVo basketItem = buyService.findBuy(basketNumber);
            basketList.add(basketItem);
        }
        return basketList;
    }

    @GetMapping("/basketList")
    public List<BasketVo> basketList(){
        return basketList;
    }

    // 구매 정보 추가
    @PostMapping("/buyOk")
    public void register(@RequestBody List<BuyDto> buyList, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        for(BuyDto buyDto : buyList){
            buyDto.setUserNumber(userNumber);
            buyDto.setDeliveryNumber(1L);

            // buyCnt 필드의 데이터 타입을 Long으로 설정
            Long buyCnt = buyDto.getBuyCnt();
            buyDto.setBuyCnt(buyCnt);

            buyService.register(buyDto);
        }
    }

    @GetMapping("/buyList")
    public List<BuyVo> buyList(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<BuyVo> buyList = buyService.findBuyOk(userNumber);
        return buyList;
    }

    // 구매가 완료되면 제거하기
    @DeleteMapping("/remove")
    public void remove(@RequestBody Long[] basketNumbers){
        for(Long basketNumber : basketNumbers){
            buyService.remove(basketNumber);
        }
    }
}
