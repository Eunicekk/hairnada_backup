package com.example.hairnada.mapper.main;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    // 헤어스타일 띄우기
    public HairVo selectHair(int number);

    // 헤어스타일 개수
    public int selectHairCnt();

    // 상품 띄우기
    public StoreVo selectStore(Long category, int number);

    // 상품 개수
    public int selectStoreCnt1();
    public int selectStoreCnt2();
    public int selectStoreCnt3();
    public int selectStoreCnt4();
    public int selectStoreCnt5();
    public int selectStoreCnt6();

    // 커뮤니티 띄우기
    public BoardVo selectBoard(int number);

    // 커뮤니티 개수
    public int selectBoardCnt();
}
