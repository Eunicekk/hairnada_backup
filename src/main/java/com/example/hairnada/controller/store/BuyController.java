package com.example.hairnada.controller.store;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.store.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class BuyController {
    private final BuyService buyService;

    @GetMapping("/buy")
    public String buy(HttpServletRequest req, Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        UserDto user = buyService.findUser(userNumber);
        model.addAttribute("user", user);

        return "store/purchase";
    }

}
