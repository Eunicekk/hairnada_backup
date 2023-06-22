package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
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
    void insert(){

    }

    @Test
    void selectAll() {
        int beforeSize = boardMapper.selectAll().size();
        boardMapper.insert(boardDto);
        assertThat(boardMapper.selectAll().size()).isEqualTo(beforeSize+1);
    }
}