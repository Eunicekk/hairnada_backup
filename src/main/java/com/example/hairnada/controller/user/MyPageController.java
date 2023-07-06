package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.BasketService;
import com.example.hairnada.service.user.MyPageService;
import com.example.hairnada.service.user.UserFileService;
import com.example.hairnada.service.user.UserService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;
    private final MyPageService myPageService;
    private final UserFileService userFileService;



    @GetMapping("/myPageMain")
    public void myPageMain(){

    }

//    @GetMapping("/myPage")
//    public UserDto myPage(HttpServletRequest req){
//        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
//
//        return userService.updateSelect(userNumber);
//    }

    @GetMapping("/myPage")
    public void myPage() {
    }


    @PostMapping("/myPage")
    public RedirectView userUpdate(HttpServletRequest req, UserDto userDto, @RequestParam("userFile") MultipartFile multipartFile) {
        HttpSession session = req.getSession();
        Long userNumber = (Long)session.getAttribute("userNumber");
        System.out.println(multipartFile.getOriginalFilename());

        userDto.setUserNumber(userNumber);

        userService.userUpdate(userDto, multipartFile);

        return new RedirectView("/user/myPage");
    }


    // 장바구니에 담긴 상품 조회하기
    @GetMapping("/myBasket")
    public void myBasket(){

    }

    @GetMapping("/myLike")
    public void myLike(){

    }

    @GetMapping("/myboard")
    public String myboard(HttpServletRequest req, Model model, Criteria03 criteria03){
        Long userNum = (Long)req.getSession().getAttribute("userNumber");
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +userNum);
//        myPageService.myBoard(userNumber);
//        redirectAttributes.addFlashAttribute("userNumber", userNum);
        model.addAttribute("myList", myPageService.myBoard(userNum, criteria03));
        model.addAttribute("pageInfo",new Page03Vo(criteria03, myPageService.getTotal( userNum)));

        return "user/myboard";
    }



}
