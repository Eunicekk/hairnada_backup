package com.example.hairnada.controller.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.service.store.StoreService;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.PageAdminListVo;
import com.example.hairnada.vo.page.SearchStoreVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

//    상품 리스트
    @GetMapping("/productList")
    public String productList(CriteriaAdminList criteriaAdminList, Model model, SearchStoreVo searchStoreVo, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<StoreVo> productList = storeService.selectStoreList(criteriaAdminList, userNumber != null ? userNumber : 0);


        System.out.println(productList);
        model.addAttribute("productList", productList);
        model.addAttribute("pageInfo", new PageAdminListVo(criteriaAdminList,storeService.findStoreListTotal()));
        model.addAttribute("searchStoreVo", searchStoreVo);

        return "store/productList";
    }

    @GetMapping("/productRead")
    public String productRead(Long storeNumber, Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        StoreVo storeVo = storeService.findStore(storeNumber, userNumber != null ? userNumber : 0);
        model.addAttribute("productList",storeVo);
        System.out.println(storeVo);
        return "store/productRead";
    }

}
