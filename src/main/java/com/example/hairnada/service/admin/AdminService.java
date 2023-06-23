package com.example.hairnada.service.admin;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.admin.AdminMapper;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<UserDto> findUserList(){
        return adminMapper.selectUserList();
    }

    // 등업 게시글 목록 조회
    @Transactional(readOnly = true)
    public List<LevelVo> findLevelList() {return adminMapper.selectLevelList();}

    // 등업 게시글 읽기
    @Transactional(readOnly = true)
    public LevelVo findLevelBoard(Long levelNumber) {
        if(levelNumber == null){
            throw new IllegalArgumentException("게시글 번호가 없습니다.");
        }

        return Optional.ofNullable(adminMapper.levelBoardRead(levelNumber))
                .orElseThrow(()-> {throw new IllegalArgumentException("존재하지 않는 게시글 번호입니다.");});
    }
    
    // 등업 요청 수락
    public void acceptQuest(Long userNumber, Long membershipNumber){
        if (membershipNumber == null || userNumber == null) {
            throw new IllegalArgumentException("회원 수정 정보가 없습니다.");
        }
        adminMapper.updateMembershipNumber(userNumber, membershipNumber);
    }

    // 상품 목록 조회
    public List<StoreDto> findStoreList(){ return adminMapper.selectStoreList(); }

    // 카테고리로 상품 조회
    public List<StoreDto> findStoreListByCategory(Long storeCategoryNumber){
        if (storeCategoryNumber == null) {
            throw new IllegalArgumentException("카테고리 선택 정보가 없습니다.");
        }
        return Optional.ofNullable(adminMapper.selectStoreListByCategory(storeCategoryNumber))
                .orElseThrow(()-> {throw new IllegalArgumentException("존재하는 게시글이 없습니다");});
    }
}
