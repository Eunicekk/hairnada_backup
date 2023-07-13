package com.example.hairnada.mapper.main;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
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


    // 상품 개수
    public int selectStoreCnt(Long storeCategoryNumber);

    // 커뮤니티 띄우기
    public BoardVo selectBoard(int number);

    // 커뮤니티 개수
    public int selectBoardCnt();
}
