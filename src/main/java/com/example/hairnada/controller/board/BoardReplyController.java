package com.example.hairnada.controller.board;

import com.example.hairnada.dto.board.BoardReplyDto;
import com.example.hairnada.service.board.BoardReplyService;
import com.example.hairnada.service.board.BoardService;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Page03Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boardReply/*")
public class BoardReplyController {
    private final BoardReplyService boardReplyService;

    @PostMapping("/reply")
    public String replyRegister(@RequestBody BoardReplyDto boardReplyDto,HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        boardReplyDto.setUserNumber(userNumber);
        System.out.println(boardReplyDto);
        boardReplyService.register(boardReplyDto);
        return "작성 성공!";
    }

    @GetMapping("/list/{boardNumber}")
    public List<BoardReplyDto> getReplyList(@PathVariable("boardNumber")Long boardNumber){
        return boardReplyService.findList(boardNumber);
    }

    @PatchMapping("/{boardReplyNumber}")
    public void replyModify(@PathVariable("boardReplyNumber")Long boardReplyNumber,
                            @RequestBody BoardReplyDto boardReplyDto){
        boardReplyDto.setBoardReplyNumber(boardReplyNumber);
        boardReplyService.modify(boardReplyDto);
    }

    @DeleteMapping("/{boardReplyNumber}")
    public void replyRemove(@PathVariable("boardReplyNumber")Long boardReplyNumber){
        boardReplyService.remove(boardReplyNumber);
    }

    @GetMapping("/{boardReplyNumber}")
    public BoardReplyDto replySearch(@PathVariable("boardReplyNumber")Long boardReplyNumber){
        return boardReplyService.findBoardReply(boardReplyNumber);
    }

    @GetMapping("list/{boardNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("boardNumber")Long boardNumber,
                                             @PathVariable("page")int page){
        Criteria03 criteria03 = new Criteria03(page, 6);
        Page03Vo page03Vo = new Page03Vo(criteria03, boardReplyService.findTotal(boardNumber));

        List<BoardReplyDto> replyList = boardReplyService.findListPage(criteria03, boardNumber);
        Map<String, Object> replyMap = new HashMap<>();
        replyMap.put("page03Vo", page03Vo);
        replyMap.put("replyList", replyList);

        return replyMap;
    }
}
