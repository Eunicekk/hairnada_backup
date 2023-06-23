package com.example.hairnada.controller.hairshop;

import com.example.hairnada.service.hairshop.HairShopService;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hairshop/*")
@RequiredArgsConstructor
public class HairShopController {
    private final HairShopService hairShopService;

    // list 페이지 띄우기 및 전체 게시물 조회하기
    @GetMapping("/list")
    public String hairshopList(Criteria03 criteria03, Model model){
        List<HairShopVo> hairShopList = hairShopService.findAll(criteria03);
        model.addAttribute("hairShopList", hairShopList);
        model.addAttribute("pageInfo", new Page03Vo(criteria03, hairShopService.getTotal()));

        return "hairshop/styleshopList";
    }


    // read 페에지 띄우기
    @GetMapping("/read")
    public String hairshopRead(Long hairShopNumber, Model model){
        HairShopVo hairShopVo = hairShopService.findHairShop(hairShopNumber);
        model.addAttribute("hairShop", hairShopVo);

        return "hairshop/styleshopRead";
    }

    // write 페이지 띄우기
    @GetMapping("/write")
    public String hairshopWrite(){
        return "hairshop/styleshopWrite";
    }
}
