package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardFileDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardFileMapperTest {

    @Autowired
    private BoardFileMapper boardFileMapper;
    private BoardFileDto boardFileDto;

    @BeforeEach
    void setUp(){
        boardFileDto = new BoardFileDto();
        boardFileDto.setBoardFileName("aaaa");
        boardFileDto.setBoardFileUuid("testUUID");
        boardFileDto.setBoardFileUploadPath("/23/02/02");
        boardFileDto.setBoardNumber(18L);
    }

    @Test
    void insert() {
        boardFileMapper.insert(boardFileDto);
        assertThat(boardFileMapper.selectList(boardFileDto.getBoardNumber()).size()).isNotEqualTo(0);
    }

    @Test
    void delete() {
        boardFileMapper.insert(boardFileDto);
        boardFileMapper.delete(boardFileDto.getBoardNumber());
        assertThat(boardFileMapper.selectList(boardFileDto.getBoardNumber()).size()).isEqualTo(0);
    }

    @Test
    void selectList() {
    }
}