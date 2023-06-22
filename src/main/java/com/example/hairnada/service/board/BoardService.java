package com.example.hairnada.service.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.mapper.board.BoardMapper;
import com.example.hairnada.vo.board.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;

//    추가
    public void register(BoardDto boardDto){
        if(boardDto == null){
            throw new IllegalArgumentException("게시물 정보가 없습니다.");
        }
        boardMapper.insert(boardDto);
    }

//    조회
    public BoardVo findBoard(Long boardNumber){
        if(boardNumber == null){
            throw new IllegalArgumentException("게시물 번호가 없습니다.");
        }
        return Optional.ofNullable(boardMapper.select(boardNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 게시물 번호");});
    }

//    전체 조회
    public List<BoardVo> findAll(){
        return boardMapper.selectAll();
    }

}
