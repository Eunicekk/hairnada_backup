package com.example.hairnada.controller.board;

import com.example.hairnada.service.board.BoardService;
import com.example.hairnada.vo.board.BoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardService boardService;
    private BoardVo boardVo;

    @BeforeEach
    void setUp(){
        boardVo = new BoardVo();
        boardVo.setUserNickName("왕자님");
        boardVo.setBoardContent("test content");
        boardVo.setBoardTitle("test Title");
        boardVo.setUserNumber(1L);
    }

    @Test
    void communityList() throws Exception{
//        doReturn(List.of()).when(boardService).findAll();
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/board/communityList"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(boardService, times(1)).findAll();
    }

    @Test
    void communityRead() {
    }

    @Test
    void communityWrite() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/board/communityWrite")
                .sessionAttr("userNumber", 1L)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}