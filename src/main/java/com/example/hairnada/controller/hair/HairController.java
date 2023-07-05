package com.example.hairnada.controller.hair;

import com.example.hairnada.mapper.hair.HairMapper;
import com.example.hairnada.service.hair.HairService;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.PageAdminListVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hair/*")
@RequiredArgsConstructor
public class HairController {
    private final HairService hairService;

    @GetMapping("/hairStyleList")
    public void hairStyleList(CriteriaAdminList criteriaAdminList, Model model){
        List<HairVo> hairStyleList = hairService.findHairList(criteriaAdminList);
        model.addAttribute("hairStyleList", hairStyleList);
        model.addAttribute("pageInfo", new PageAdminListVo(criteriaAdminList, hairService.getHairTotal()));
    }

    @GetMapping("/hairStyleRead")
    public String hairStyleRead(Long hairNumber, Model model){
        HairVo hairVo = hairService.findHair(hairNumber);
        model.addAttribute("hairList", hairVo);
        return "hair/hairStyleRead";
    }
}
