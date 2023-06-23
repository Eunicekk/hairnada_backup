package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.level.LevelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    // 회원 전체 조회
    public List<UserDto> selectUserList();

    // 등업 게시글 목록 조회
    public List<LevelVo> selectLevelList();

    // 등업 게시글 읽기
    public LevelVo levelBoardRead(long levelNumber);

    // 등업 요청 수락
    public void updateMembershipNumber(@Param("userNumber")Long userNumber, @Param("membershipNumber")Long membershipNumber);

    // 상품 리스트 목록
    public List<StoreDto> selectStoreList();

    // 상품 카테고리로 검색
    public List<StoreDto> selectStoreListByCategory(Long storeCategoryNumber);

    // 상품 제목으로 검색
    public List<StoreDto> selectStoreListByTitle(String storeTitle);
}
