package com.example.hairnada.service.user;

import com.example.hairnada.mapper.user.MyLikeMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria11;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyLikeService {

    private final MyLikeMapper myLikeMapper;

//    커뮤니티 좋아요
    public List<BoardVo> likeCommunity(Long userNumber, Criteria11 criteria11){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        return Optional.ofNullable(myLikeMapper.likeCommunity(userNumber, criteria11)).orElseThrow(()->{
            throw new IllegalArgumentException("좋아요한 게시글이 없습니다.");
        });
    }

//    커뮤니티 좋아요 페이징
    public int getTotal(Long userNumber){return myLikeMapper.getTotal(userNumber);}

    //    헤어스타일 좋아요
    public List<HairVo> likeHair(Long userNumber, Criteria11 criteria11){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        return Optional.ofNullable(myLikeMapper.likeHair(userNumber, criteria11)).orElseThrow(()->{
            throw new IllegalArgumentException("좋아요한 게시글이 없습니다.");
        });
    }

//    헤어스타일 좋아요 페이징
    public int getTotal2(Long userNumber){return myLikeMapper.getTotal2(userNumber);}


//    미용실 좋아요
    public List<HairShopVo> likeHairShop(Long userNumber, Criteria11 criteria11){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        return Optional.ofNullable(myLikeMapper.likeHairShop(userNumber, criteria11)).orElseThrow(()->{
            throw new IllegalArgumentException("좋아요한 게시글이 없습니다.");
        });
    }


//    미용실 좋아요 페이징
    public int getTotal3(Long userNumber){return myLikeMapper.getTotal3(userNumber);}


//    제품 좋아요
    public List<StoreVo> likeStore(Long userNumber, Criteria11 criteria11){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        return Optional.ofNullable(myLikeMapper.likeStore(userNumber, criteria11)).orElseThrow(()->{
            throw new IllegalArgumentException("좋아요한 게시글이 없습니다.");
        });
    }

//    제품 좋아요 페이징
    public int getTotal4(Long userNumber){return myLikeMapper.getTotal4(userNumber);}


//    케어샵 좋아요
    public List<CareShopVo> likeCareShop(Long userNumber, Criteria11 criteria11){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보 누락");
        }

        return Optional.ofNullable(myLikeMapper.likeCareShop(userNumber, criteria11)).orElseThrow(()->{
            throw new IllegalArgumentException("좋아요한 게시글이 없습니다.");
        });
    }

//    케어샵 좋아요 페이징
    public int getTotal5(Long userNumber){return myLikeMapper.getTotal5(userNumber);}

}
