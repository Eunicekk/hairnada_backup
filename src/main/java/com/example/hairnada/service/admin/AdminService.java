package com.example.hairnada.service.admin;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.admin.AdminMapper;
import com.example.hairnada.vo.hair.HairVo;
import com.example.hairnada.vo.level.LevelVo;
import com.example.hairnada.vo.page.CriteriaAdmin;
import com.example.hairnada.vo.page.CriteriaAdminList;
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
    public List<UserDto> findUserList(CriteriaAdmin criteriaAdmin){
        return adminMapper.selectUserList(criteriaAdmin);
    }

    // 회원 수 조회
    @Transactional(readOnly = true)
    public int getUserTotal(){
        return adminMapper.userTotal();
    }

    // 등업 게시글 목록 조회
    @Transactional(readOnly = true)
    public List<LevelVo> findLevelList(CriteriaAdmin criteriaAdmin) {return adminMapper.selectLevelList(criteriaAdmin);}

    // 등업 게시글 수
    @Transactional(readOnly = true)
    public int getLevelTotal(){
        return adminMapper.levelTotal();
    }

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
    public List<StoreDto> findStoreList(CriteriaAdminList criteriaAdminList){
        return adminMapper.selectStoreList(criteriaAdminList);
    }

    // 상품 게시글 수
    @Transactional(readOnly = true)
    public int getStoreTotal(){
        return adminMapper.storeTotal();
    }

    // 카테고리로 상품 조회
    public List<StoreDto> findStoreListByCategory(Long storeCategoryNumber){
        if (storeCategoryNumber == null) {
            throw new IllegalArgumentException("카테고리 선택 정보가 없습니다.");
        }
        return Optional.ofNullable(adminMapper.selectStoreListByCategory(storeCategoryNumber))
                .orElseThrow(()-> {throw new IllegalArgumentException("존재하는 게시글이 없습니다");});
    }

    // 이름으로 상품 조회
    public List<StoreDto> findStoreListByTitle(String storeTitle){
        if (storeTitle == null) {
            throw new IllegalArgumentException("상품 제목을 입력해주세요");
        }
        return Optional.ofNullable(adminMapper.selectStoreListByTitle(storeTitle))
                .orElseThrow(()->{throw new IllegalArgumentException("일치하는 상품이 없습니다.");});
    }

    // 헤어 스타일 조회
    public List<HairVo> findHairList(CriteriaAdminList criteriaAdminList){
        return adminMapper.selectHairList(criteriaAdminList);
    }

    // 헤어 게시글 수
    @Transactional(readOnly = true)
    public int getHairTotal(){
        return adminMapper.hairTotal();
    }

    // 헤어스 스타일 업로드
    public void registerHair(HairDto hairDto){
        if (hairDto == null) {
            throw new IllegalArgumentException("헤어스타일 정보를 제대로 기입해주세요.");
        }
        adminMapper.insertHair(hairDto);
    }

    // 카테고리별 헤어스타일 조회
    public List<HairDto> findHairListByCategory(Long lengthNumber, Long shapeNumber, String hairGender){
        if (hairGender == null || lengthNumber == null || shapeNumber == null) {
            throw new IllegalArgumentException("카테고리 선택 누락!!");
        }

        return Optional.ofNullable(adminMapper.selectHairListByCategory( lengthNumber, shapeNumber, hairGender))
                .orElseThrow(()-> {throw new IllegalArgumentException("일치하는 게시글이 없습니다!!"); });
    }

    // 이름으로 헤어스타일 조회
    public List<HairDto> findHairListByName(String hairName){
        if (hairName == null) {
            throw new IllegalArgumentException("검색어를 제대로 입력해주세요");
        }

        return Optional.ofNullable(adminMapper.selectHairListByName(hairName))
                .orElseThrow(()-> {throw new IllegalArgumentException("일치하는 게시글이 없습니다 !!");});
    }
}
