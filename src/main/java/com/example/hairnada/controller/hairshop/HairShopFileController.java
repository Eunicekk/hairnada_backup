package com.example.hairnada.controller.hairshop;

import com.example.hairnada.dto.hairshop.HairShopFileDto;
import com.example.hairnada.service.hairshop.HairShopFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hairshopFile/*")
@RequiredArgsConstructor
public class HairShopFileController {
    private final HairShopFileService hairShopFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<HairShopFileDto> imgList(Long hairShopNumber){
        return hairShopFileService.findList(hairShopNumber);
    }
}
