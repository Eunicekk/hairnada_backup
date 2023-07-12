package com.example.hairnada.mapper.main;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.hairVo.HairVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
class MainMapperTest {
    @Autowired
    private MainMapper mainMapper;

    @Test
    void selectHair() {
        List<Integer> list = new ArrayList<>();
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Collections.addAll(list, numbers);

        List<HairVo> result = mainMapper.selectHair(list);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(6);
    }

    @Test
    void selectHairCnt() {
    }

    @Test
    void selectBoard() {
        List<Integer> list = new ArrayList<>();
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Collections.addAll(list, numbers);

        List<BoardVo> result = mainMapper.selectBoard(list);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(6);
    }

    @Test
    void selectBoardCnt() {
    }
}