package com.example.hairnada.service.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.mapper.board.BoardMapper;
import com.example.hairnada.vo.board.BoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    private BoardMapper boardMapper;
    @InjectMocks
    private BoardService boardService;
    private BoardDto boardDto;
    private BoardVo boardVo;

    @BeforeEach
    void setUp(){
        boardDto = new BoardDto();
        boardDto.setBoardTitle("test title");
        boardDto.setBoardContent("test content");
        boardDto.setBoardCategoryNumber(1L);
        boardDto.setUserNumber(1L);

        boardVo = new BoardVo();
        boardVo.setBoardTitle("test title");
        boardVo.setBoardContent("test content");
        boardVo.setBoardCategoryNumber(1L);
        boardVo.setUserNumber(1L);
        boardVo.setUserNickName("왕자님");

    }

    @Test
    @DisplayName("등록👍")
    void register() {
        doNothing().when(boardMapper).insert(any(BoardDto.class));

        boardService.register(boardDto);

        verify(boardMapper, times(1)).insert(boardDto);
    }

    @Test
    @DisplayName("조회")
    void findBoard() {
        doReturn(boardVo).when(boardMapper).select(any(Long.class));

        BoardVo foundBoard = boardService.findBoard(1L);

        assertThat(foundBoard).isEqualTo(boardVo);
    }

    @Test
    @DisplayName("전체 조회")
    void findAll() {
        doReturn(List.of(boardVo)).when(boardMapper).selectAll();

        List<BoardVo> foundList = boardService.findAll();

        assertThat(foundList).contains(boardVo);
    }
}