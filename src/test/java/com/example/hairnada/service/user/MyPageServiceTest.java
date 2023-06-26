package com.example.hairnada.service.user;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.mapper.user.MyPageMapper;
import com.example.hairnada.vo.board.BoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyPageServiceTest {
    @Mock
    private MyPageMapper myPageMapper;

    @InjectMocks
    private MyPageService myPageService;
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
    @DisplayName("작성글 조회")
    void myPage() {
//        doReturn(List.of(boardVo)).when(myPageMapper).myBoard(any(Long.class));
//
//        List<BoardVo> list = myPageService.myBoard(1L);
//
//        assertThat(list).contains(boardVo);

    }
}