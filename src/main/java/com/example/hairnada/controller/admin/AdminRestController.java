package com.example.hairnada.controller.admin;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.admin.AdminService;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/adminR/*")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    // 등업 요청 수락
    @PostMapping("/membership")
    public void acceptQuest(Long userNumber, Long membershipNumber){
        adminService.acceptQuest(userNumber, membershipNumber);
    }

    // 카테고리로 상품 조회
    @GetMapping("/storeList")
    public List<StoreDto> findStoreList(Long storeCategoryNumber){
        List<StoreDto> categoryStore =  adminService.findStoreListByCategory(storeCategoryNumber);
        return categoryStore;
    }

    // 이름으로 상품 조회
    @GetMapping("/storeTitle")
    public List<StoreDto> findStoreListByTitle(String storeTitle){
        List<StoreDto> titleStore = adminService.findStoreListByTitle(storeTitle);
        return titleStore;
    }

    // 카테고리로 헤어 조회
    @GetMapping("/hairList")
    public List<HairDto> findHairList ( Long lengthNumber, Long shapeNumber, String hairGender){
        List<HairDto> categoryHair = adminService.findHairListByCategory( lengthNumber, shapeNumber,hairGender);
        System.out.println(categoryHair.toString());
        return categoryHair;
    }

    // 이름으로 헤어스타일 조회
    @GetMapping("/hairName")
    public List<HairDto> findHairListByName(String hairName){
        List<HairDto> nameHair = adminService.findHairListByName(hairName);
        return nameHair;
    }

}
