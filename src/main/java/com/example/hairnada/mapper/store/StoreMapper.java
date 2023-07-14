package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchStoreVo;
import com.example.hairnada.vo.store.CategoryVo;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {

//    조회
    public StoreVo select(Long storeNumber, @Param("userNumber") Long userNumber);

//    상품 리스트
    public List<StoreVo> selectList(@Param("criteria") CriteriaAdminList criteriaAdminList, @Param("userNumber") Long userNumber);

//    상품 토탈
    public int storeTotal();

//    상품 카테고리
    public List<StoreVo> selectStoreCategory(Long storeCategoryNumber);

    public List<StoreVo> selectStoreSearch(@Param("searchStoreVo")SearchStoreVo searchStoreVo, @Param("criteria") CriteriaAdminList criteriaAdminList, @Param("userNumber")Long userNumber);

    public int selectSearchTotal(SearchStoreVo searchStoreVo);

    public int likeTotal(Long storeNumber);

    public List<CategoryVo> storeCount();

}
