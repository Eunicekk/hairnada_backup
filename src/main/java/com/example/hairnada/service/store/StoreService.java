package com.example.hairnada.service.store;

import com.example.hairnada.dto.store.StoreDto;
import com.example.hairnada.mapper.store.StoreMapper;
import com.example.hairnada.vo.hairVo.StoreVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchStoreVo;
import com.example.hairnada.vo.store.CategoryVo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {
    private final StoreMapper storeMapper;

//    조회
    @Transactional(readOnly = true)
    public StoreVo findStore(Long storeNumber, Long userNumber){
        if (storeNumber == null){
            throw new IllegalArgumentException("상품 번호가 없습니다.");
        }
        return Optional.ofNullable(storeMapper.select(storeNumber, userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 상품 번호");
                });
    }

//    상품 리스트
    public List<StoreVo> selectStoreList(CriteriaAdminList criteriaAdminList, Long userNumber){
        return storeMapper.selectList(criteriaAdminList, userNumber);
    }

//    상품 토탈 수
    @Transactional(readOnly = true)
    public int findStoreListTotal(){return storeMapper.storeTotal();}

//    상품 카테고리로 조회
    public List<StoreVo> findStoreListByCategory(Long storeCategoryNumber){
        if (storeCategoryNumber == null){
            throw new IllegalArgumentException("선택한 카테고리의 정보가 없습니둥");
        }
        return Optional.ofNullable(storeMapper.selectStoreCategory(storeCategoryNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하는 게시물이 없음");});
    }

//    카테고리 조회
    public List<StoreVo> findStoreList(SearchStoreVo searchStoreVo, CriteriaAdminList criteriaAdminList, Long userNumber){
        if (searchStoreVo == null){
            throw new IllegalArgumentException("뭐가 없습니다.");
        }
        return storeMapper.selectStoreSearch(searchStoreVo, criteriaAdminList, userNumber);
    }

    public int findSearchTotal(SearchStoreVo searchStoreVo){
        if (searchStoreVo == null){
            throw new IllegalArgumentException("searchStoreVo 누락!");
        }
        return storeMapper.selectSearchTotal(searchStoreVo);
    }

    public int findLikeTotal(Long storeNumber){
        if (storeNumber == null){
            throw new IllegalArgumentException("몰랑");
        }
        return storeMapper.likeTotal(storeNumber);
    }

    public List<CategoryVo> findCategoryCnt(){
        List<CategoryVo> findCategoryCnt = storeMapper.storeCount();
        return findCategoryCnt;
    }


}