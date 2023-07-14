package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.buy.AdminBuyDto;
import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.dto.level.LevelDto;
import com.example.hairnada.dto.level.LevelFileDto;
import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.level.LevelVo;
import com.example.hairnada.vo.page.CriteriaAdmin;
import com.example.hairnada.vo.page.CriteriaAdminList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    // 로그인
    public Long login(@Param("userId")String userId, @Param("userPassword")String userPassword);
    // 회원 전체 조회
    public List<UserDto> selectUserList(CriteriaAdmin criteriaAdmin);

    // 회원수
    public int userTotal();

    // 회원 정지
    public void stopUser(Long userNumber);

    // 회원 복구
    public void restoreUser(Long userNumber);

    // 등업 게시글 목록 조회
    public List<LevelVo> selectLevelList(CriteriaAdmin criteriaAdmin);

    // 등업 게시글 수
    public int levelTotal();

    // 등업 게시글 읽기
    public LevelVo levelBoardRead(Long levelNumber);

    // 등업 게시글 사진
    public LevelFileDto selectLevelFile(Long levelNumber);

    // 등업 요청 수락
    public void updateMembershipNumber(@Param("userNumber")Long userNumber, @Param("membershipNumber")Long membershipNumber);

    // 수락 목록
    public List<LevelDto> selectCompleteLevel();

    // 상품 리스트 목록
    public List<StoreVo> selectStoreList(CriteriaAdminList criteriaAdminList);

    // 상품 게시글 수
    public int storeTotal();

    // 상품 작성
    public void insertStore(StoreDto storeDto);

    // 상품 카테고리로 검색
    public List<StoreVo> selectStoreListByCategory(@Param("storeCategoryNumber") Long storeCategoryNumber, @Param("storeTitle")String storeTitle, @Param("criteria")CriteriaAdminList criteriaAdminList);

    // 상품 카테고리 검색 수
    public int categoryStoreTotal(@Param("storeCategoryNumber") Long storeCategoryNumber, @Param("storeTitle")String storeTitle);

    // 상품 제목으로 검색
//    public List<StoreVo> selectStoreListByTitle(String storeTitle, @Param("criteria")CriteriaAdminList criteriaAdminList);

    // 상품 제목으로 검색 수
//    public int titleStoreTotal(String storeTitle);

    // 상품 게시글 읽기
    public StoreVo storeRead(Long storeNumber);

    // 상품 게시글 삭제
    public void deleteStore(Long storeNumber);

    // 상품 게시글 수정
    public void updateStore(StoreDto storeDto);

    // 헤어 리스트 목록
    public List<HairVo> selectHairList(CriteriaAdminList criteriaAdminList);

    // 헤어리스트 수
    public int hairTotal();

    // 카테고리 헤어리스트 수
    public int categoryHairTotal(@Param("lengthNumber") Long lengthNumber,
                                 @Param("shapeNumber") Long shapeNumber,
                                 @Param("hairGender") String hairGender,
                                 @Param("hairName") String hairName);

    // 제목 헤어리스트 수
    public int nameHairTotal(@Param("hairName") String hairName);

    // 헤어 업로드
    public void insertHair(HairDto hairDto);

    // 헤어 카테고리로 검색
    public List<HairVo> selectHairListByCategory(
                                                  @Param("lengthNumber") Long lengthNumber,
                                                  @Param("shapeNumber") Long shapeNumber,
                                                  @Param("hairGender") String hairGender,
                                                  @Param("hairName") String hairName,
                                                  @Param("criteria") CriteriaAdminList criteriaAdminList);

    // 제목으로 헤어 검색
//    public List<HairVo> selectHairListByName(@Param("hairName")String hairName, @Param("criteria")CriteriaAdminList criteriaAdminList);

    // 헤어 게시글 읽기
    public HairVo hairRead(Long hairNumber);

    // 헤어 게시글 삭제
    public void deleteHair(Long hairNumber);

    // 헤어 게시글 수정시 기본 정보
    public HairDto hairInfo(Long hairNumber);

    // 헤어 게시글 수정
    public void updateHair(HairDto hairDto);

    // 배송 미완료 목록 조회
    public List<AdminBuyDto> selectIncompleteRequest(CriteriaAdmin criteriaAdmin);

    // 배송 미완료 목록 수
    public int incompleteTotal();

    // 배송 완료 목록 조회
    public List<AdminBuyDto> selectCompleteList(@Param("criteria")CriteriaAdmin criteriaAdmin);

    // 배송 완료 목록 수
    public int completeTotal();

    // 배송 상태 변경
    public void updateDelivery(@Param("deliveryNumber")Long deliveryNumber, @Param("buyNumber")Long buyNumber);


}
