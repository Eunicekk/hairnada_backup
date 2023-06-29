package com.example.hairnada.controller.careshop;

import com.example.hairnada.dto.careshop.CareShopDto;
import com.example.hairnada.service.careshop.CareShopFileService;
import com.example.hairnada.service.careshop.CareShopService;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import com.example.hairnada.vo.page.SearchVo;
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
@RequestMapping("/careshop/*")
@RequiredArgsConstructor
public class CareShopController {
    private final CareShopService careShopService;
    private final CareShopFileService careShopFileService;

    // list 페이지 띄우기 및 전체 게시물 조회하기
    @GetMapping("/list")
    public String careshopList(Criteria03 criteria03, Model model, HttpServletRequest req, SearchVo searchVo){
        List<CareShopVo> careShopList = careShopService.findAll(criteria03);
        model.addAttribute("careShopList", careShopList);
        model.addAttribute("search", searchVo);
        model.addAttribute("pageInfo", new Page03Vo(criteria03, careShopService.getTotal()));

        return "careshop/careshopList";
    }


    // read 페에지 띄우기
    @GetMapping("/read")
    public String careshopRead(Long careShopNumber, Model model, HttpServletRequest req){
        CareShopVo careShopVo = careShopService.findCareShop(careShopNumber);
        model.addAttribute("careShop", careShopVo);

        return "careshop/careshopRead";
    }


    // write 페이지 띄우기
    @GetMapping("/write")
    public String careshopWrite(HttpServletRequest req){
        return "careshop/careshopWrite";
    }


    @PostMapping("/write")
    public RedirectView careshopWrite(CareShopDto careShopDto, HttpServletRequest req, RedirectAttributes redirectAttributes, @RequestParam("careShopFile")List<MultipartFile> files){
        // RedirectAttributes는 리다이렉트 전용 Model 객체라고 생각하면 된다.
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        careShopDto.setUserNumber(userNumber);
        careShopService.register(careShopDto);

        redirectAttributes.addFlashAttribute("careShopNumber", careShopDto.getCareShopNumber());

        if(files != null){
            try {
                careShopFileService.registerAndSaveFiles(files, careShopDto.getCareShopNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/careshop/list");
    }


    // modify 페이지 띄우기
    @GetMapping("/modify")
    public String careShopModify(Long careShopNumber, Model model){
        CareShopVo careShopVo = careShopService.findCareShop(careShopNumber);
        model.addAttribute("careShop", careShopVo);

        return "careshop/careshopModify";
    }


    @PostMapping("/modify")
    public RedirectView careShopModify(CareShopDto careShopDto, RedirectAttributes redirectAttributes, @RequestParam("careShopFile") List<MultipartFile> files){
        try {
            careShopService.modify(careShopDto, files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("careShopNumber", careShopDto.getCareShopNumber());
        return new RedirectView("/careshop/read");
    }


    // remove 실행하기
    @GetMapping("/remove")
    public RedirectView careShopRemove(Long careShopNumber){
        careShopService.remove(careShopNumber);
        return new RedirectView("/careshop/list");
    }


    // search 실행하기
    @GetMapping("/search")
    public String search(Criteria03 criteria03, SearchVo searchVo, Model model, HttpServletRequest req){
        List<CareShopVo> careShopList = careShopService.search(criteria03, searchVo);
        model.addAttribute("careShopList", careShopList);
        model.addAttribute("search", searchVo);
        model.addAttribute("pageInfo", new Page03Vo(criteria03, careShopService.searchTotal(searchVo)));

        return "/careshop/careshopList";
    }
}
