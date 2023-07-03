package com.example.hairnada.service.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.mapper.store.StoreMapper;
import com.example.hairnada.vo.page.CriteriaAdminList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {
    private final StoreMapper storeMapper;

//    상품 리스트
    public List<StoreDto> findStoreList(CriteriaAdminList criteriaAdminList){
        return storeMapper.selectList(criteriaAdminList);
    }

//    상품 토탈 수
    @Transactional(readOnly = true)
    public int findStoreListTotal(){return storeMapper.storeTotal();}

//    상품 카테고리로 조회
    public List<StoreDto> findStoreListByCategory(Long storeCategoryNumber){
        if (storeCategoryNumber == null){
            throw new IllegalArgumentException("선택한 카테고리의 정보가 없습니둥");
        }
        return Optional.ofNullable(storeMapper.selectStoreCategory(storeCategoryNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하는 게시물이 없음");});
    }
}