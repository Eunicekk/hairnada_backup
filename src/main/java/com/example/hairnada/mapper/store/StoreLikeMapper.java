package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.board.BoardLikeDto;
import com.example.hairnada.dto.store.StoreLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreLikeMapper {
    // 좋아요 추가
    public void insert(StoreLikeDto storeLikeDto);

    //좋아요 삭제
    public void delete(StoreLikeDto storeLikeDto);

    public List<Long> check(Long userNumber);
}
