package com.example.hairnada.service.user;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.mapper.user.MyBoardLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyBoardLikeService {

    private final MyBoardLikeMapper myBoardLikeMapper;

    @Transactional(readOnly = true)
    public List<Long> checkLike(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(myBoardLikeMapper.check(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("회원 번호가 존재하지 않습니다.");});}

//    추가
    public void addLike(BoardLikeDto boardLikeDto){
        if(boardLikeDto == null){
            throw new IllegalArgumentException("게시글정보 누락");
        }

        myBoardLikeMapper.insert(boardLikeDto);
    }

//    삭제
    public void deleteLike(BoardLikeDto boardLikeDto){
        if(boardLikeDto == null){
            throw new IllegalArgumentException("게시글 정보 누락");
        }

        myBoardLikeMapper.delete(boardLikeDto);

    }

}
