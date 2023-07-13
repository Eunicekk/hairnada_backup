package com.example.hairnada.service.board;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.hairshop.HairShopLikeDto;
import com.example.hairnada.mapper.board.BoardLikeMapper;
import com.example.hairnada.mapper.hairshop.HairShopLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardLikeService {
    private final BoardLikeMapper boardLikeMapper;

    // 좋아요 추가
    public void addLike(BoardLikeDto boardLikeDto){
        if(boardLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵 정보가 없습니다.");
        }
        boardLikeMapper.insert(boardLikeDto);
    }

    // 좋아요 삭제
    public void subtractLike(BoardLikeDto boardLikeDto){
        if(boardLikeDto == null){
            throw new IllegalArgumentException("좋아요한 헤어샵이 존재하지 않습니다.");
        }
        boardLikeMapper.delete(boardLikeDto);
    }
}
