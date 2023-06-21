package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;
    private BoardDto boardDto;

    @BeforeEach
    void setUp(){
        boardDto = new BoardDto();
        boardDto.setBoardTitle("test Title");
        boardDto.setBoardContent("test Content");
        boardDto.setUserNumber(1L);
    }

    @Test
    void selectAll() {

    }
}