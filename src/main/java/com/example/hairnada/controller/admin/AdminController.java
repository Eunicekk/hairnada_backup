package com.example.hairnada.controller.admin;

import com.example.hairnada.dto.buy.AdminBuyDto;
import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.hair.HairFileDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.store.StoreFileDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.admin.AdminFileService;
import com.example.hairnada.service.admin.AdminService;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.level.LevelVo;
import com.example.hairnada.vo.page.CriteriaAdmin;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.PageAdminListVo;
import com.example.hairnada.vo.page.PageAdminVo;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminFileService adminFileService;

    // 로그인
    @GetMapping("/adminLogin")
    public void adminLogin(Model model){}

    @PostMapping("/adminLogin")
    public RedirectView adminLogin(String userId, String userPassword, HttpServletRequest req, Model model){
        Long isAdmin = adminService.adminLogin(userId, userPassword);

        if(isAdmin == 4){
            req.getSession().setAttribute("membershipNumber", isAdmin);
            model.addAttribute("admin", isAdmin);
            return new RedirectView("/admin/userList");
        } else {
            return new RedirectView("/admin/adminLogin");
        }

    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        // 세션 초기화
        req.getSession().invalidate();
        return "admin/adminLogin";
    }

    // 유저 리스트
    @GetMapping("/userList")
    public void memberList(CriteriaAdmin criteriaAdmin, Model model, HttpServletRequest req){
        Long membershipNumber = (Long)req.getSession().getAttribute("membershipNumber");
        System.out.println("*******membershipNumber" + membershipNumber);
        List<UserDto> userList = adminService.findUserList(criteriaAdmin);
        model.addAttribute("userList", userList);
        model.addAttribute("pageInfo", new PageAdminVo(criteriaAdmin, adminService.getUserTotal()));
    }




    // 배송 관리
    @GetMapping("/delivery")
    public void delivery(CriteriaAdmin criteriaAdmin, Model model){
        List<AdminBuyDto> incompleteList = adminService.findIncompleteList(criteriaAdmin);
        model.addAttribute("incompleteList", incompleteList);
        model.addAttribute("pageInfo", new PageAdminVo(criteriaAdmin, adminService.getIncompleteTotal()));
        model.addAttribute("incompleteTotal", adminService.getIncompleteTotal());
        model.addAttribute("completeTotal", adminService.getCompleteTotal());
    }


    // 헤어 리스트
    @GetMapping("/hairList")
    public void hairList(CriteriaAdminList criteriaAdminList,Model model){
       List<HairVo> hairList = adminService.findHairList(criteriaAdminList);

        model.addAttribute("hairList", hairList);
        model.addAttribute("pageInfo", new PageAdminListVo(criteriaAdminList, adminService.getHairTotal()));
    }


    // 헤어 게시글 읽기
    @GetMapping("/hairRead")
    public void hairRead(Long hairNumber, Model model){
        HairVo hairRead = adminService.lookUpHair(hairNumber);
        model.addAttribute("hair", hairRead);
    }


    // 헤어 게시글 업로드
    @GetMapping("/hairUpload")
    public void hairUpload(){

    }

    // 헤어 게시글 수정
    @GetMapping("/hairModify")
    public void hairModify(Long hairNumber, Model model){
        HairDto hairInfo = adminService.findHairInfo(hairNumber);
        List<HairFileDto> hairFileList = adminFileService.findHairList(hairNumber);
        model.addAttribute("hairInfo", hairInfo);
        model.addAttribute("hairFile", hairFileList);
    }

    // 헤어 게시글 사진 수정
    @PostMapping("/hairModify")
    public RedirectView updateHairFile( HairDto hairDto, @RequestParam("hairFile") List<MultipartFile> files,  RedirectAttributes redirectAttributes) throws IOException {
        try {
            adminService.modifyHair(hairDto, files);
        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttributes.addAttribute("hairNumber", hairDto.getHairNumber());
        return new RedirectView("/admin/hairRead?hairNumber=" + hairDto.getHairNumber());
    }

    // 헤어 게시글 업로드
    @PostMapping("/hairUpload")
    public RedirectView hairUpload(HairDto hairDto, HttpServletRequest req, RedirectAttributes redirectAttributes
            , @RequestParam("hairFile") List<MultipartFile> files){
        adminService.registerHair(hairDto);
        redirectAttributes.addFlashAttribute("hairNumber", hairDto.getHairNumber());

        if(files != null){
            try {
                adminFileService.registerHairAndSaveFiles(files, hairDto.getHairNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/admin/hairList");
    }

    // 헤어 게시글 삭제
    @GetMapping("/hairRemove")
    public RedirectView hairRemove(Long hairNumber){
        adminService.removeHair(hairNumber);
        return new RedirectView("/admin/hairList");
    }

    // 등업 신청 목록
    @GetMapping("/membership")
    public void membership(CriteriaAdmin criteriaAdmin, Model model){
        List<LevelVo> levelList = adminService.findLevelList(criteriaAdmin);
        model.addAttribute("levelList", levelList);
        model.addAttribute("pageInfo", new PageAdminVo(criteriaAdmin, adminService.getLevelTotal()));
    }

    // 등업 신청 게시글 읽기
    @GetMapping("/levelUp")
    public void levelUP(Long levelNumber, Model model){
        LevelVo levelVo = adminService.findLevelBoard(levelNumber);
        model.addAttribute("LevelBoard", levelVo);
    }

//    // 회원 기존 등급 조회
//    @GetMapping("/findUserMembership")
//    public Long levelUp(@Param("userNumber")Long userNumber){
//        Long userMembership = adminService.matchingMembership(userNumber);
//        return userMembership;
//    }

    // 상품 리스트
    @GetMapping("/storeList")
    public void storeList(CriteriaAdminList criteriaAdminList, Model model){
        List<StoreVo> storeList = adminService.findStoreList(criteriaAdminList);
        System.out.println(storeList.toString());
        model.addAttribute("storeList", storeList);
        model.addAttribute("pageInfo", new PageAdminListVo(criteriaAdminList, adminService.getStoreTotal()));
    }

    // 상품 읽어오기
    @GetMapping("/storeRead")
    public void storeRead(Long storeNumber, Model model){
        StoreVo storeRead = adminService.lookUpStore(storeNumber);
        String storeMainContent = adminService.lookUpStore(storeNumber).getStoreMainContent();
        model.addAttribute("storeRead", storeRead);
        model.addAttribute("storeMainContent", storeMainContent);
    }

    // 상품 올리기
    @GetMapping("/storeUpload")
    public void storeUpload(){}

    // 상품 올리기
    @PostMapping("/storeUpload")
    public RedirectView storeUpload(StoreDto storeDto, HttpServletRequest req, RedirectAttributes redirectAttributes, @RequestParam("storeFile")List<MultipartFile> files) throws IOException {
        adminService.registerStore(storeDto);
        redirectAttributes.addFlashAttribute("storeNumber", storeDto.getStoreNumber());

        if(files != null){
            try {
                adminFileService.registerStoreAndSaveFiles(files, storeDto.getStoreNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/admin/storeList");
    }

    // 상품 게시글 삭제
    @GetMapping("/storeRemove")
    public RedirectView removeStore(Long storeNumber){
        adminService.removeStore(storeNumber);
        return new RedirectView("/admin/storeList");
    }



}
