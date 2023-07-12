package com.example.hairnada.controller.main;

import com.example.hairnada.service.main.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MainRestController {
    private final MainService mainService;

    // 헤어스타일 띄우기
    @GetMapping("/hair")
    public List<Integer> mainHair(){
        int min = 1;
        int max = mainService.getHairCnt();
        int count = 6;

        Set<Integer> result = new HashSet<>();
        Random random = new Random();
        while(result.size() < count){
            int number = random.nextInt(max - min + 1) + min;
            result.add(number);
        }
        List<Integer> hairCntList = new ArrayList<>(result);

        return hairCntList;
    }

    // 상품 띄우기
//    @GetMapping("/store")
//    public List<Integer> mainStore(){
//        int min = 1;
//        int max = 0;
//        int count = 4;
//
//        for (int categoryNumber = 1; categoryNumber <= 6; categoryNumber++) {
//            max = mainService.getStoreCnt(categoryNumber);
//
//            Set<Integer> result = new HashSet<>();
//            Random random = new Random();
//            while (result.size() < count) {
//                int number = random.nextInt(max - min + 1) + min;
//                result.add(number);
//            }
//            List<Integer> storeCntList = new ArrayList<>(result);
//            storeCntLists.add(storeCntList);
//        }
//
//        return boardCntList;
//    }

    // 커뮤니티 띄우기
    @GetMapping("/board")
    public List<Integer> mainBoard(){
        int min = 1;
        int max = mainService.getBoardCnt();
        int count = 6;

        Set<Integer> result = new HashSet<>();
        Random random = new Random();
        while(result.size() < count){
            int number = random.nextInt(max - min + 1) + min;
            result.add(number);
        }
        List<Integer> boardCntList = new ArrayList<>(result);

        return boardCntList;
    }
}
