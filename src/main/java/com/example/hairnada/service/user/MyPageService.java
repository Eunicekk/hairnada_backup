package com.example.hairnada.service.user;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.user.MyPageMapper;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyPageService {

    private final MyPageMapper myPageMapper;

//    작성글 조회
    public List<BoardVo> myBoard(Long userNumber, Criteria03 criteria03){
        if(userNumber == null){
            throw new IllegalArgumentException("회원번호 누락");
        }

    return Optional.ofNullable(myPageMapper.myBoard(userNumber, criteria03)).orElseThrow(()->{
            throw new IllegalArgumentException("작성한 게시글이 없습니다.");
        });

    }

    //    전체 게시글 조회
    @Transactional(readOnly = true)
    public int getTotal(Long userNumber){
        return myPageMapper.selectTotal( userNumber);
    }



}
