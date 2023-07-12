package com.example.hairnada.mapper.main;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    // 헤어스타일 띄우기
    public List<HairVo> selectHair(@Param("hairCntList") List<Integer> hairCntList);

    // 헤어스타일 개수
    public int selectHairCnt();

    // 상품 띄우기

    // 상품 개수
    public int selectStoreCnt(Long storeCategoryNumber);

    // 커뮤니티 띄우기
    public List<BoardVo> selectBoard(@Param("boardCntList") List<Integer> boardCntList);

    // 커뮤니티 개수
    public int selectBoardCnt();
}
