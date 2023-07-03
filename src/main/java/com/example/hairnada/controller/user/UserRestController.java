package com.example.hairnada.controller.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.service.user.MyLikeService;
import com.example.hairnada.service.user.UserService;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria11;
import com.example.hairnada.vo.page.Page11Vo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
@Slf4j
public class UserRestController {
   private final UserService userService;

   @GetMapping("/userNickname")
   public int userNickname(String userNickname){

      return userService.checkUserNickname(userNickname);
   }



}
