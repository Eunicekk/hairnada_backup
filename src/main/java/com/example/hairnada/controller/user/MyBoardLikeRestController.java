package com.example.hairnada.controller.user;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.service.user.MyBoardLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/likes/*")
@RequiredArgsConstructor
public class MyBoardLikeRestController {

    private final MyBoardLikeService myBoardLikeService;

    // 좋아요 확인
    @GetMapping("/check")
    public List<Long> checkLike(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<Long> likeList = myBoardLikeService.checkLike(userNumber);
        return likeList;
    }

    @PostMapping("/add")
    public void addLike(@RequestBody BoardLikeDto boardLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        boardLikeDto.setUserNumber(userNumber);
        System.out.println(userNumber+"회원 번호다~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(boardLikeDto+"디티오다~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        myBoardLikeService.addLike(boardLikeDto);
    }

    @DeleteMapping("/delete")
    public void deleteLike(@RequestBody BoardLikeDto boardLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        boardLikeDto.setUserNumber(userNumber);
        myBoardLikeService.deleteLike(boardLikeDto);

    }

}
