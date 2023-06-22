package com.example.hairnada.mapper.hairshop;

import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HairShopMapper {
    // 전체 조회
    public List<HairShopVo> selectAll(Criteria03 criteria03);

    // 전체 게시글 수 조회
    public int selectTotal();
}
