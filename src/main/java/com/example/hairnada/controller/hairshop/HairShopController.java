package com.example.hairnada.controller.hairshop;

import com.example.hairnada.dto.hairshop.HairShopDto;
import com.example.hairnada.service.hairshop.HairShopFileService;
import com.example.hairnada.service.hairshop.HairShopService;
import com.example.hairnada.vo.page.SearchVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hairshop/*")
@RequiredArgsConstructor
public class HairShopController {
    private final HairShopService hairShopService;
    private final HairShopFileService hairShopFileService;

    // list 페이지 띄우기 및 전체 게시물 조회하기
    @GetMapping("/list")
    public String hairshopList(Criteria03 criteria03, Model model, HttpServletRequest req){
        List<HairShopVo> hairShopList = hairShopService.findAll(criteria03);
        model.addAttribute("hairShopList", hairShopList);
        model.addAttribute("pageInfo", new Page03Vo(criteria03, hairShopService.getTotal()));

        return "hairshop/styleshopList";
    }


    // read 페에지 띄우기
    @GetMapping("/read")
    public String hairshopRead(Long hairShopNumber, Model model, HttpServletRequest req){
        HairShopVo hairShopVo = hairShopService.findHairShop(hairShopNumber);
        model.addAttribute("hairShop", hairShopVo);

        return "hairshop/styleshopRead";
    }


    // write 페이지 띄우기
    @GetMapping("/write")
    public String hairshopWrite(HttpServletRequest req){
        return "hairshop/styleshopWrite";
    }


    @PostMapping("/write")
    public RedirectView hairshopWrite(HairShopDto hairShopDto, HttpServletRequest req, RedirectAttributes redirectAttributes, @RequestParam("hairShopFile")List<MultipartFile> files){
        // RedirectAttributes는 리다이렉트 전용 Model 객체라고 생각하면 된다.
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        hairShopDto.setUserNumber(userNumber);
        hairShopService.register(hairShopDto);

        redirectAttributes.addFlashAttribute("hairShopNumber", hairShopDto.getHairShopNumber());

        if(files != null){
            try {
                hairShopFileService.registerAndSaveFiles(files, hairShopDto.getHairShopNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/hairshop/list");
    }


    // modify 페이지 띄우기
    @GetMapping("/modify")
    public String hairShopModify(Long hairShopNumber, Model model){
        HairShopVo hairShopVo = hairShopService.findHairShop(hairShopNumber);
        model.addAttribute("hairShop", hairShopVo);

        return "hairshop/styleshopModify";
    }


    @PostMapping("/modify")
        public RedirectView hairShopModify(HairShopDto hairShopDto, RedirectAttributes redirectAttributes, @RequestParam("hairShopFile") List<MultipartFile> files){
            try {
                hairShopService.modify(hairShopDto, files);
            } catch (IOException e) {
                e.printStackTrace();
            }
            redirectAttributes.addFlashAttribute("hairShopNumber", hairShopDto.getHairShopNumber());
            return new RedirectView("/hairshop/read");
    }


    // remove 실행하기
    @GetMapping("/remove")
    public RedirectView hairShopRemove(Long hairShopNumber){
        hairShopService.remove(hairShopNumber);
        return new RedirectView("/hairshop/list");
    }


    // search 실행하기
    @GetMapping("/search")
    public String search(Criteria03 criteria03, SearchVo searchVo, Model model, HttpServletRequest req){
        List<HairShopVo> hairShopList = hairShopService.search(criteria03, searchVo);
        model.addAttribute("hairShopList", hairShopList);
        model.addAttribute("search", searchVo);
        model.addAttribute("pageInfo", new Page03Vo(criteria03, hairShopService.searchTotal(searchVo)));

        return "/hairshop/styleshopList";
    }
}
