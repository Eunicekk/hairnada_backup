package com.example.hairnada.controller.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.service.store.StoreService;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.PageAdminListVo;
import com.example.hairnada.vo.page.SearchStoreVo;
import io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/storeR/*")
@RequiredArgsConstructor
public class StoreRestController {
    private final StoreService storeService;

//    상품 리스트
    @GetMapping("/productSearchList/{page}")
   public Map<String, Object> searchStore(SearchStoreVo searchStoreVo, @PathVariable("page") int page){
        CriteriaAdminList criteriaAdminList = new CriteriaAdminList(page, 12);
        int total = storeService.findSearchTotal(searchStoreVo);
        PageAdminListVo pageAdminListVo = new PageAdminListVo(criteriaAdminList, total);
        Map<String, Object> map = new HashMap<>();
        List<StoreVo> list = storeService.findStoreList(searchStoreVo, criteriaAdminList);
        map.put("page", pageAdminListVo);
        map.put("productList", list);

        return map;
    }



}
