package com.example.hairnada.mapper.board;

import com.example.hairnada.dto.board.BoardDto;
import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;
    private BoardDto boardDto;
    private Criteria03 criteria03;
    private BoardVo boardVo;
    private SearchVo searchVo;

    @BeforeEach
    void setUp(){
        criteria03 = new Criteria03(1,9);
        boardDto = new BoardDto();
        searchVo = new SearchVo();
        boardDto.setBoardTitle("test Title");
        boardDto.setBoardContent("test Content");
        boardDto.setUserNumber(1L);
        searchVo.setKeyword("");
        searchVo.setBoardCategoryNumber(1L);
    }

    @Test
    void insert(){

    }

    @Test
    void delete(){
        boardMapper.delete(boardDto.getBoardNumber());
        assertThat(boardMapper.select(boardDto.getBoardNumber())).isNull();
    }

    @Test
    void update(){
        boardDto.setBoardTitle("update title");
        boardDto.setBoardContent("update content");

        boardMapper.update(boardDto);

        assertThat(boardMapper.select(boardDto.getBoardNumber()).getBoardTitle())
                .isEqualTo(boardDto.getBoardTitle());
    }

    @Test
    void selectAll() {
//        int beforeSize = boardMapper.selectAll().size();
//        boardMapper.insert(boardDto);
//        assertThat(boardMapper.selectAll().size()).isEqualTo(beforeSize+1);
    }

    @Test
    void selectBoardSearch(){
        List<BoardVo> boardList = boardMapper.selectBoardSearch(searchVo, criteria03);
        System.out.println("boardList ===============" + boardList);
    }

}