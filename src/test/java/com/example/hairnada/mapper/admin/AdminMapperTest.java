package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.vo.level.LevelVo;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;
    private LevelVo levelVo;
    private HairDto hairDto;

    @BeforeEach
    void setUp(){
        levelVo = new LevelVo();

    }


    @Test
    @DisplayName("회원 전체 조회")
    void selectUserList() {
//        assertThat(adminMapper.selectUserList().size())
//                .isEqualTo(1);
    }

    @Test
    @DisplayName("등업 신청 게시글 조회")
    void selectLevelList(){
//        assertThat(adminMapper.selectLevelList().size())
//                .isEqualTo(1);
    }

    @Test
    @DisplayName("등업 신청 게시글 읽기")
    void levelBoardRead(){
        assertThat(adminMapper.levelBoardRead(1L).getUserId()).isEqualTo("aaa@naver.com");
    }

    @Test
    @DisplayName("등업 요청 수락")
    void updateMembershipNumber(){

        adminMapper.updateMembershipNumber(adminMapper.levelBoardRead(1L).getUserNumber(), adminMapper.levelBoardRead(1L).getMembershipNumber());

//      assertThat(adminMapper.selectUserList().get(5).getMembershipName()).isEqualTo("스타일 전문가");

    }


    @Test
    @DisplayName("상품 목록 조회")
    void selectStoreList(){
        assertThat(adminMapper.selectStoreList()).size().isEqualTo(6);
    }

    @Test
    @DisplayName("카테고리로 상품 조회")
    void selectStoreListByCategory(){
        Long categoryNumber = adminMapper.selectStoreListByCategory(1L).get(0).getStoreCategoryNumber();
        assertThat(categoryNumber).isEqualTo(1);
    }
 
    @Test
    @DisplayName("이름으로 상품 조회")
    void selectStoreListByTitle(){
        Long categoryNumber = adminMapper.selectStoreListByTitle("미쟝센").get(0).getStoreCategoryNumber();
        assertThat(categoryNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("헤어 스타일 조회")
    void selectHairList(){
        assertThat(adminMapper.selectHairList()).size().isEqualTo(8);
    }

    @Test
    @DisplayName("카테고리로 헤어스타일 조회")
    void selectHairListByCategory(){
        List<HairDto> hairList = adminMapper.selectHairListByCategory(1L, 1L, "F");
        log.info(hairList.toString());
    }

    @Test
    @DisplayName("제목으로 헤어스타일 조회")
    void selectHairListByName(){
        List<HairDto> hairList = adminMapper.selectHairListByName("테슬");
        assertThat(hairList.get(0).getHairName()).isEqualTo("테슬컷");
    }

}