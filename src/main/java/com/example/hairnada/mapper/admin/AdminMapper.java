package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.buy.AdminBuyDto;
import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.level.LevelVo;
import com.example.hairnada.vo.page.CriteriaAdmin;
import com.example.hairnada.vo.page.CriteriaAdminList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    // 회원 전체 조회
    public List<UserDto> selectUserList(CriteriaAdmin criteriaAdmin);

    // 회원수
    public int userTotal();

    // 등업 게시글 목록 조회
    public List<LevelVo> selectLevelList(CriteriaAdmin criteriaAdmin);

    // 등업 게시글 수
    public int levelTotal();

    // 등업 게시글 읽기
    public LevelVo levelBoardRead(long levelNumber);

    // 등업 요청 수락
    public void updateMembershipNumber(@Param("userNumber")Long userNumber, @Param("membershipNumber")Long membershipNumber);
    // 상품 리스트 목록
    public List<StoreDto> selectStoreList(CriteriaAdminList criteriaAdminList);

    // 상품 게시글 수
    public int storeTotal();

    // 상품 카테고리로 검색
    public List<StoreDto> selectStoreListByCategory(Long storeCategoryNumber);

    // 상품 제목으로 검색
    public List<StoreDto> selectStoreListByTitle(String storeTitle);

    // 헤어 리스트 목록
    public List<HairVo> selectHairList(CriteriaAdminList criteriaAdminList);

    // 헤어리스트 수
    public int hairTotal();

    // 헤어 업로드
    public void insertHair(HairDto hairDto);

    // 헤어 카테고리로 검색
    public List<HairDto> selectHairListByCategory(
                                                  @Param("lengthNumber") Long lengthNumber,
                                                  @Param("shapeNumber") Long shapeNumber,
                                                  @Param("hairGender") String hairGender);

    // 제목으로 헤어 검색
    public List<HairDto> selectHairListByName(@Param("hairName")String hairName);

    // 헤어 게시글 읽기
    public HairVo hairRead(Long hairNumber);

    // 헤어 게시글 삭제
    public void deleteHair(Long hairNumber);

    // 헤어 게시글 수정시 기본 정보
    public HairDto hairInfo(Long hairNumber);

    // 배송 미완료 목록 조회
    public List<AdminBuyDto> selectIncompleteRequest(CriteriaAdmin criteriaAdmin);

    // 배송 미완료 목록 수
    public int incompleteTotal();

    // 배송 완료 목록 조회
    public List<AdminBuyDto> selectCompleteList(CriteriaAdmin criteriaAdmin);

    // 배송 완료 목록 수
    public int completeTotal();

    // 배송 상태 변경
    public void updateDelivery(@Param("deliveryNumber")Long deliveryNumber, @Param("buyNumber")Long buyNumber);


}
