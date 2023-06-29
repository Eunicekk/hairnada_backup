package com.example.hairnada.controller.user;

import com.example.hairnada.service.user.MyLikeService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria11;
import com.example.hairnada.vo.page.Page03Vo;
import com.example.hairnada.vo.page.Page11Vo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
@Slf4j
public class MyLikeRestController {
    private final MyLikeService myLikeService;

//    커뮤니티
    @GetMapping("/likeCommunity/{page}")
    public Map<String, Object> likeCommunity(HttpServletRequest req, @PathVariable("page") int page){
        Criteria11 criteria11 = new Criteria11();
        criteria11.setPage(page);
        Long userNum = (Long)req.getSession().getAttribute("userNumber");

        List<BoardVo> likeboard = myLikeService.likeCommunity(userNum, criteria11);
        Page11Vo pageinfo = new Page11Vo(criteria11, myLikeService.getTotal(userNum));

        Map<String, Object> data = new HashMap<>();

        data.put("likeboard", likeboard);
        data.put("pageinfo", pageinfo);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + data.toString());

        return data;
    }

//    스타일
    @GetMapping("/likeHair/{page}")
    public Map<String, Object> likeHair(HttpServletRequest req, @PathVariable("page") int page ){
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Criteria11 criteria11 = new Criteria11();
        criteria11.setPage(page);
        Long userNum = (Long)req.getSession().getAttribute("userNumber");

        List<HairVo> likeStyle = myLikeService.likeHair(userNum, criteria11);
        Page11Vo pageinfo = new Page11Vo(criteria11, myLikeService.getTotal2(userNum));

        Map<String, Object> data = new HashMap<>();

        data.put("likeStyle", likeStyle);
        data.put("pageinfo", pageinfo);

        return data;
    }

//    미용실
    @GetMapping("/likeHairShop/{page}")
    public Map<String, Object> likeHairShop(HttpServletRequest req, @PathVariable("page") int page){
        Criteria11 criteria11 = new Criteria11();
        criteria11.setPage(page);
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        List<HairShopVo> likeShop = myLikeService.likeHairShop(userNumber, criteria11);
        Page11Vo pageinfo = new Page11Vo(criteria11, myLikeService.getTotal3(userNumber));

        Map<String, Object> data = new HashMap<>();
        data.put("likeShop", likeShop);
        data.put("pageinfo", pageinfo);

        return data;
    }

//    제품
    @GetMapping("/likeStore/{page}")
    public Map<String, Object> likeStore(HttpServletRequest req, @PathVariable("page")int page){
        Criteria11 criteria11 = new Criteria11();
        criteria11.setPage(page);
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        List<StoreVo> likeStore = myLikeService.likeStore(userNumber, criteria11);
        Page11Vo pageinfo = new Page11Vo(criteria11, myLikeService.getTotal4(userNumber));

        Map<String, Object> data = new HashMap<>();
        data.put("likeStore", likeStore);
        data.put("pageinfo", pageinfo);

        return data;
    }

}
