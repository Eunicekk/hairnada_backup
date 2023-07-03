package com.example.hairnada.controller.hair;

import com.example.hairnada.dto.buy.AdminBuyDto;
import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.service.admin.AdminService;
import com.example.hairnada.service.hair.HairService;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.page.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hairStyleR/*")
@RequiredArgsConstructor
public class HairRestController {
    private final HairService hairService;

//    이름으로 헤어스타일 조회
    @GetMapping("/hairStyleName")
    public List<HairDto> SearchHairStyle(String hairName){
        if (hairName == null) {
            throw new IllegalArgumentException("검색어를 제대로 입력해주세요");
        }
        List<HairDto> searchHairName = hairService.findHairListByName(hairName);
        return searchHairName;
    }

    @GetMapping("/hairSearchList/{page}")
    public Map<String, Object> searchHair(SearchHairVo searchHairVo, @PathVariable("page") int page){
        CriteriaAdminList criteriaAdminList = new CriteriaAdminList(page, 12);
        int total = hairService.findSearchTotal(searchHairVo);
        PageAdminListVo pageAdminListVo = new PageAdminListVo(criteriaAdminList, total);
        Map<String, Object> map = new HashMap<>();
        List<HairVo> list =  hairService.findHairList(searchHairVo, criteriaAdminList);
        map.put("page", pageAdminListVo);
        map.put("hairList", list);

        return map;
    }



}
