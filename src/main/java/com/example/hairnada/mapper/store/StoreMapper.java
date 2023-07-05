package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchStoreVo;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {

//    조회
    public StoreVo select(Long storeNumber);

//    상품 리스트
    public List<StoreVo> selectList(CriteriaAdminList criteriaAdminList);

//    상품 토탈
    public int storeTotal();

//    상품 카테고리
    public List<StoreVo> selectStoreCategory(Long storeCategoryNumber);

    public List<StoreVo> selectStoreSearch(@Param("searchStoreVo")SearchStoreVo searchStoreVo, @Param("criteria") CriteriaAdminList criteriaAdminList);

    public int selectSearchTotal(SearchStoreVo searchStoreVo);

}
