package com.example.hairnada.service.hair;

import com.example.hairnada.dto.hair.HairDto;
import com.example.hairnada.mapper.hair.HairMapper;
import com.example.hairnada.vo.hairVo.HairVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.CriteriaAdminList;
import com.example.hairnada.vo.page.SearchHairVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class HairService {
    private final HairMapper hairMapper;

//    조회
    @Transactional(readOnly = true)
    public HairVo findHair(Long hairNumber, Long userNumber){
        if (hairNumber == null){
            throw new IllegalArgumentException("뭐가 없습니다.");
        }
        return Optional.ofNullable(hairMapper.select(hairNumber, userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("뭐가 없습니다.");
                });
    }

    // 헤어 스타일 조회
    public List<HairVo> findHairList(CriteriaAdminList criteriaAdminList, Long userNumber){
        return hairMapper.selectHairList(criteriaAdminList, userNumber);
    }

    // 헤어 게시글 수
    @Transactional(readOnly = true)
    public int getHairTotal(){
        return hairMapper.hairTotal();
    }

    // 카테고리별 헤어스타일 조회
    public List<HairDto> findHairListByCategory(Long lengthNumber, Long shapeNumber, String hairGender){
        if (hairGender == null || lengthNumber == null || shapeNumber == null) {
            throw new IllegalArgumentException("카테고리 선택 누락!!");
        }

        return Optional.ofNullable(hairMapper.selectHairListByCategory( lengthNumber, shapeNumber, hairGender))
                .orElseThrow(()-> {throw new IllegalArgumentException("일치하는 게시글이 없습니다!!"); });
    }

    // 이름으로 헤어스타일 조회
    public List<HairDto> findHairListByName(String hairName){
        if (hairName == null) {
            throw new IllegalArgumentException("검색어를 제대로 입력해주세요");
        }

        return Optional.ofNullable(hairMapper.selectHairListByName(hairName))
                .orElseThrow(()-> {throw new IllegalArgumentException("일치하는 게시글이 없습니다 !!");});
    }

//    카테고리,검색 조회
    public List<HairVo> findHairList(SearchHairVo searchHairVo, CriteriaAdminList criteriaAdminList, Long userNumber){
        if (searchHairVo == null){
            throw new IllegalArgumentException("뭐가 없습니다.");
        }
        return hairMapper.selectHairSearch(searchHairVo, criteriaAdminList, userNumber);
    }

    public int findSearchTotal(SearchHairVo searchHairVo){
        if (searchHairVo == null) {
            throw new IllegalArgumentException("searchHairVo 누락!");
        }
        return hairMapper.selectSearchTotal(searchHairVo);
    }

    public int findLikeTotal(Long hairNumber){
        if (hairNumber == null){
            throw new IllegalArgumentException("몰라우");
        }
        return hairMapper.likeTotal(hairNumber);
    }

    @Transactional(readOnly = true)
    public List<HairShopVo> findHairShop(){
        Random random = new Random();
        List<HairShopVo> hairShopList = new ArrayList<>();
        int number;

        for(int i = 0; i < 3; i++){
            number = random.nextInt(getHairShopCnt()) + 1;
            hairShopList.add(hairMapper.selectHairShop(number));
        }
        return hairShopList;
    }

    @Transactional(readOnly = true)
    public int getHairShopCnt(){
        return hairMapper.selectHairShopCnt();
    }
}

