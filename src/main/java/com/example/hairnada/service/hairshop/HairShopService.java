package com.example.hairnada.service.hairshop;

import com.example.hairnada.mapper.hairshop.HairShopMapper;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
