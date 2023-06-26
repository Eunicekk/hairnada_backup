package com.example.hairnada.service.user;

import com.example.hairnada.mapper.user.MyLikeMapper;
import com.example.hairnada.mapper.user.MyPageMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
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



}
