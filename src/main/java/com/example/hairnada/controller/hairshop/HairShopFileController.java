package com.example.hairnada.controller.hairshop;

import com.example.hairnada.dto.hairshop.HairShopFileDto;
import com.example.hairnada.service.hairshop.HairShopFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hairshopFile/*")
@RequiredArgsConstructor
public class HairShopFileController {
    private final HairShopFileService hairShopFileService;

    @Value("${file.dir}")
    private String fileDir;

    // 파일 리스트 띄우기
    @GetMapping("/imgList")
    public List<HairShopFileDto> imgList(Long hairShopNumber){
        return hairShopFileService.findList(hairShopNumber);
    }

    // 서버 컴퓨터에 저장된 파일을 복사하여 넘겨주는 핸들러
    @GetMapping("display")
    public byte[] display(String hairShopFileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, hairShopFileName));
    }
}
