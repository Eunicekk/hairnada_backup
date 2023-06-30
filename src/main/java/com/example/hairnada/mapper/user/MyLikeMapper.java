package com.example.hairnada.mapper.user;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
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

//    헤어스타일 좋아요
    public List<HairVo> likeHair(@Param("userNumber")Long userNumber, @Param("criteria") Criteria11 criteria11 );

//    헤어스타일 좋아요 페이징
    public int getTotal2(Long userNumber);

//    미용실 좋아요
    public List<HairShopVo> likeHairShop(@Param("userNumber")Long userNumber, @Param("criteria")Criteria11 criteria11);

//    미용실 좋아요 페이징
    public int getTotal3(Long userNumber);

//    재품 좋아요
    public List<StoreVo> likeStore(@Param("userNumber")Long userNumber, @Param("criteria")Criteria11 criteria11);

//    제품 좋아요 페이징
    public int getTotal4(Long userNumber);

//    케어샵 좋아요
    public List<CareShopVo> likeCareShop(@Param("userNumber")Long userNumber, @Param("criteria")Criteria11 criteria11);

//    케어샵 페이징
    public int getTotal5(Long userNumber);

}
