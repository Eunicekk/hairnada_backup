package com.example.hairnada.controller.careshop;

import com.example.hairnada.dto.careshop.CareShopFileDto;
import com.example.hairnada.service.careshop.CareShopFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/careshopFile/*")
@RequiredArgsConstructor
public class CareShopFileController {
    private final CareShopFileService careShopFileService;

    @Value("${file.dir}")
    private String fileDir;

    // 파일 리스트 띄우기
    @GetMapping("/imgList")
    public List<CareShopFileDto> imgList(Long careShopNumber){
        return careShopFileService.findList(careShopNumber);
    }

    // 서버 컴퓨터에 저장된 파일을 복사하여 넘겨주는 핸들러
    @GetMapping("/display")
    public byte[] display(String careShopFileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, careShopFileName));
    }
}
