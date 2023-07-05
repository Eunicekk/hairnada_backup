package com.example.hairnada.controller.store;

import com.example.hairnada.dto.store.StoreReplyDto;
import com.example.hairnada.service.store.StoreReplyService;
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
@RequestMapping("/storeReply/*")
@RequiredArgsConstructor
public class StoreReplyController {
    private final StoreReplyService storeReplyService;

    @PostMapping("/reply")
    public String replyRegister(@RequestBody StoreReplyDto storeReplyDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        storeReplyDto.setUserNumber(userNumber);
        System.out.println(storeReplyDto);
        storeReplyService.register(storeReplyDto);
        return "작성 성공이올시다";
    }

    @GetMapping("/list/{storeNumber}")
    public List<StoreReplyDto> getReplyList(@PathVariable("storeNumber")Long storeNumber){
        return storeReplyService.findList(storeNumber);
    }

    @PatchMapping("/{storeReplyNumber}")
    public void replyModify(@PathVariable("storeReplyNumber")Long storeReplyNumber,
                            @RequestBody StoreReplyDto storeReplyDto){
        storeReplyDto.setStoreReplyNumber(storeReplyNumber);
        storeReplyService.modify(storeReplyDto);
    }

    @DeleteMapping("/{storeReplyNumber}")
    public void replyRemove(@PathVariable("storeReplyNumber")Long storeReplyNumber){
        storeReplyService.remove(storeReplyNumber);
    }

    @GetMapping("list/{storeNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("storeNumber")Long storeNumber,
                                             @PathVariable("page")int page){
        Criteria03 criteria03 = new Criteria03(page, 6);
        Page03Vo page03Vo = new Page03Vo(criteria03, storeReplyService.findTotal(storeNumber));

        List<StoreReplyDto> replyList = storeReplyService.findListPage(criteria03, storeNumber);
        Map<String, Object>replyMap = new HashMap<>();
        replyMap.put("page03Vo", page03Vo);
        replyMap.put("replyList", replyList);

        return replyMap;
    }
}
