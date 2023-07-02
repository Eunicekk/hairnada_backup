package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardReplyDto;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardReplyMapperTest {

    @Autowired
    private BoardReplyMapper boardReplyMapper;
    private BoardReplyDto boardReplyDto;

    @BeforeEach
    void setUp(){
        boardReplyDto = new BoardReplyDto();
        boardReplyDto.setBoardReplyContent("test");
        boardReplyDto.setUserNumber(1L);
        boardReplyDto.setBoardNumber(54L);
    }

    @Test
    void insert() {
        boardReplyMapper.insert(boardReplyDto);
        List<BoardReplyDto> list =  boardReplyMapper.selectList(54L);
        assertThat(list.get(0).getBoardReplyContent()).isEqualTo(boardReplyDto.getBoardReplyContent());
    }

    @Test
    void selectList() {
    }

    @Test
    void select() {
        assertThat(boardReplyMapper.select(1L).getUserNickName()).isEqualTo("공주");
    }

    @Test
    void update() {
        boardReplyDto.setBoardReplyNumber(1L);
        boardReplyDto.setBoardReplyContent("update");
        boardReplyMapper.update(boardReplyDto);

        assertThat(boardReplyMapper.select(1L).getBoardReplyContent()).isEqualTo("update");
    }

    @Test
    void delete() {
        boardReplyMapper.delete(1L);
        assertThat(boardReplyMapper.selectList(boardReplyDto.getBoardNumber()).size())
                .isEqualTo(4);
    }

    @Test
    void selectListPage() {
    }

    @Test
    void selectTotal() {
    }
}