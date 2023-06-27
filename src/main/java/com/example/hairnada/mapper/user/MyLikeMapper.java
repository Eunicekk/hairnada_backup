package com.example.hairnada.mapper.user;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.Criteria11;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyLikeMapper {

//    커뮤니티 좋아요
    public List<BoardVo> likeCommunity(@Param("userNumber")Long userNumber, @Param("criteria") Criteria11 criteria11);

//    커뮤니티 좋아요 페이징
    public int getTotal(Long userNumber);

}
