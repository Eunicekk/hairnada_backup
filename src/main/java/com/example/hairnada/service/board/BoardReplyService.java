package com.example.hairnada.service.board;

import com.example.hairnada.dto.board.BoardReplyDto;
import com.example.hairnada.mapper.board.BoardReplyMapper;
import com.example.hairnada.vo.page.Criteria03;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardReplyService {
    private final BoardReplyMapper boardReplyMapper;

    public void register(BoardReplyDto boardReplyDto){
        System.out.println(boardReplyDto);
        if(boardReplyDto == null){
            throw new IllegalArgumentException("댓글 정보 누락");
        }
        boardReplyMapper.insert(boardReplyDto);
    }

    public List<BoardReplyDto> findList(Long boardNumber){
        if(boardNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return boardReplyMapper.selectList(boardNumber);
    }

    public BoardReplyDto findBoardReply(Long boardReplyNumber){
        if(boardReplyNumber == null){
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        return Optional.ofNullable(boardReplyMapper.select(boardReplyNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 댓글 번호");});
    }

    public void modify(BoardReplyDto boardReplyDto){
        if (boardReplyDto == null){
            throw new IllegalArgumentException("댓글 수정정보 누락");
        }
        boardReplyMapper.update(boardReplyDto);
    }

    public void remove(Long boardReplyNumber){
        if(boardReplyNumber == null){
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        boardReplyMapper.delete(boardReplyNumber);
    }
    public List<BoardReplyDto> findListPage(Criteria03 criteria03, Long boardNumber){
        if (criteria03 == null || boardNumber == null){
            throw new IllegalArgumentException("댓글 페이징 정보 누락");
        }
        return boardReplyMapper.selectListPage(criteria03, boardNumber);
    }

    public int findTotal(Long boardNumber){
        if (boardNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return boardReplyMapper.selectTotal(boardNumber);
    }
}
