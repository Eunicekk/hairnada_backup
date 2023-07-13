package com.example.hairnada.service.main;

import com.example.hairnada.mapper.main.MainMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService {
    private final MainMapper mainMapper;

    // 해어스타일 조회
    @Transactional(readOnly = true)
    public List<HairVo> findHair(){
        Random random = new Random();
        List<HairVo> hairList = new ArrayList<>();
        int number;

        for(int i=0; i<6; i++){
            number = random.nextInt(getHairCnt()) + 1;
            hairList.add(mainMapper.selectHair(number));
        }

        return hairList;
    }

    // 헤어스타일 개수
    @Transactional(readOnly = true)
    public int getHairCnt(){
        return mainMapper.selectHairCnt();
    }

    // 상품 조회


    // 상품 개수
    @Transactional(readOnly = true)
    public int getStoreCnt(Long storeCategoryNumber){
        return mainMapper.selectStoreCnt(storeCategoryNumber);
    }

    // 커뮤니티 조회
    @Transactional(readOnly = true)
    public List<BoardVo> findBoard(){
        Random random = new Random();
        List<BoardVo> boardList = new ArrayList<>();
        int number;

        for(int i=0; i<6; i++){
            number = random.nextInt(getBoardCnt()) + 1;
            boardList.add(mainMapper.selectBoard(number));
        }

        return boardList;
    }

    // 커뮤니티 개수
    @Transactional(readOnly = true)
    public int getBoardCnt(){
        return mainMapper.selectBoardCnt();
    }
}
