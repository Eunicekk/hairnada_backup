package com.example.hairnada.mapper.careshop;

import com.example.hairnada.dto.careshop.CareShopDto;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CareShopMapper {
    // 전체 조회
    public List<CareShopVo> selectAll(Criteria03 criteria03);

    // 전체 게시글 수 조회
    public int selectTotal();

    // 게시물 선택
    public CareShopVo select(Long careShopNumber);

    // 게시물 삽입
    public void insert(CareShopDto careShopDto);

    // 게시물 삭제
    public void delete(Long careShopNumber);

    // 게시물 수정
    public void update(CareShopDto careShopDto);

    // 게시물 검색
    public List<CareShopVo> search(@Param("criteria") Criteria03 criteria03, @Param("search") SearchVo searchVo);

    // 게시물 검색 개수
    public int searchTotal(@Param("search") SearchVo searchVo);
}
