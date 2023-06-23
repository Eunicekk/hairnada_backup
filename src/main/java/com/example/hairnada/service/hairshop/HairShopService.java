package com.example.hairnada.service.hairshop;

import com.example.hairnada.mapper.hairshop.HairShopMapper;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HairShopService {
    private final HairShopMapper hairShopMapper;

    //  전제 조회
    @Transactional(readOnly = true)
    public List<HairShopVo> findAll(Criteria03 criteria03){
        return hairShopMapper.selectAll(criteria03);
    }

    // 전체 게시물 수
    @Transactional(readOnly = true)
    public int getTotal(){
        return hairShopMapper.selectTotal();
    }

    // 게시물 한개 조회
    @Transactional(readOnly = true)
    public HairShopVo findHairShop(Long hairShopNumber){
        if(hairShopNumber == null){
            throw new IllegalArgumentException("헤어샵 번호가 없습니다.");
        }
        return Optional.ofNullable(hairShopMapper.select(hairShopNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("헤어샵 번호가 존재하지 않습니다.");});
    }
}
