package com.example.hairnada.service.admin;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.admin.AdminMapper;
import static org.assertj.core.api.Assertions.*;

import com.example.hairnada.vo.level.LevelVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class AdminServiceTest {

    @Mock
    private AdminMapper adminMapper;

    @InjectMocks
    private AdminService adminService;

    private UserDto userDto;
    private LevelVo levelVo;
    private StoreDto storeDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        levelVo = new LevelVo();
        storeDto = new StoreDto();
    }



    @Test
    @DisplayName("회원 목록 조회")
    void findUserList() {
       doReturn(List.of(userDto)).when(adminMapper).selectUserList();

       List<UserDto> foundUserList = adminService.findUserList();

       assertThat(foundUserList).size().isEqualTo(1);
    }

    @Test
    @DisplayName("등업 신청 게시글 조회")
    void findLevelList(){
        doReturn(List.of(levelVo)).when(adminMapper).selectLevelList();

        List<LevelVo> foundLevelList = adminService.findLevelList();

        assertThat(foundLevelList).size().isEqualTo(1);
    }

    @Test
    @DisplayName("등업 신청 게시글 읽기")
    void findLevelBoard(){
        doReturn(levelVo).when(adminMapper).levelBoardRead(any(Long.class));

        LevelVo foundLevelBoard = adminService.findLevelBoard(1L);

        assertThat(foundLevelBoard).isEqualTo(levelVo);
    }

    @Test
    @DisplayName("등업 요청 수락")
    void acceptQuest(){
        doNothing().when(adminMapper).updateMembershipNumber(any(Long.class), any(Long.class));

        adminService.acceptQuest(1L, 2L);

        verify(adminMapper , times(1)).updateMembershipNumber(1L, 2L);
    }

    @Test
    @DisplayName("상품 목록 조회")
    void findStoreList(){
        doReturn(List.of(storeDto)).when(adminMapper).selectStoreList();

        List<StoreDto> foundStoreList = adminService.findStoreList();

        assertThat(foundStoreList).size().isEqualTo(1);
    }

    @Test
    @DisplayName("카테고리로 상품 조회")
    void findStoreListByCategoryNumber(){
        doReturn(List.of(storeDto)).when(adminMapper).selectStoreListByCategory(any(Long.class));

        List<StoreDto> foundStoreListByCategory =  adminService.findStoreListByCategory(1L);

        assertThat(foundStoreListByCategory).size().isEqualTo(1);

    }
}