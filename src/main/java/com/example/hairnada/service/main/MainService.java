package com.example.hairnada.service.main;

import com.example.hairnada.mapper.main.MainMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService {
    private final MainMapper mainMapper;

    // 해어스타일 조회
    @Transactional(readOnly = true)
    public List<HairVo> findHair(List<Integer> list){
        return mainMapper.selectHair(list);
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
    public List<BoardVo> findBoard(List<Integer> list){
        return mainMapper.selectBoard(list);
    }

    // 커뮤니티 개수
    @Transactional(readOnly = false)
    public int getBoardCnt(){
        return mainMapper.selectBoardCnt();
    }
}
