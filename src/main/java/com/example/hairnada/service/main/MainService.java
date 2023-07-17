package com.example.hairnada.service.main;

import com.example.hairnada.mapper.main.MainMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.main.RandomProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        Set<Integer> selectedNumbers = new HashSet<>();

        for(int i=0; i<6; i++){
            do {
                number = random.nextInt(getHairCnt()) + 1;
            } while (!selectedNumbers.add(number));
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
    @Transactional(readOnly = true)
    public RandomProduct findStore(){
        RandomProduct randomProduct = new RandomProduct();
        Random random = new Random();
        int number;

        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt1()) + 1;
            randomProduct.getCategory01().add(mainMapper.selectStore(1L, number));
        }
        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt2()) + 1;
            randomProduct.getCategory02().add(mainMapper.selectStore(2L, number));
        }
        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt3()) + 1;
            randomProduct.getCategory03().add(mainMapper.selectStore(3L, number));
        }
        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt4()) + 1;
            randomProduct.getCategory04().add(mainMapper.selectStore(4L, number));
        }
        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt5()) + 1;
            randomProduct.getCategory05().add(mainMapper.selectStore(5L, number));
        }
        for(int i=0; i<4; i++){
            number = random.nextInt(getStoreCnt6()) + 1;
            randomProduct.getCategory06().add(mainMapper.selectStore(6L, number));
        }

        return randomProduct;
    }


    // 상품 개수
    @Transactional(readOnly = true)
    public int getStoreCnt1(){
        return mainMapper.selectStoreCnt1();
    }
    @Transactional(readOnly = true)
    public int getStoreCnt2(){
        return mainMapper.selectStoreCnt2();
    }
    @Transactional(readOnly = true)
    public int getStoreCnt3(){
        return mainMapper.selectStoreCnt3();
    }
    @Transactional(readOnly = true)
    public int getStoreCnt4(){
        return mainMapper.selectStoreCnt4();
    }
    @Transactional(readOnly = true)
    public int getStoreCnt5(){
        return mainMapper.selectStoreCnt5();
    }
    @Transactional(readOnly = true)
    public int getStoreCnt6(){
        return mainMapper.selectStoreCnt6();
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
