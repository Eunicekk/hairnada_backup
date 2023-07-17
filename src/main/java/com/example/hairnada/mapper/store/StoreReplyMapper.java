package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.store.StoreReplyDto;
import com.example.hairnada.vo.page.Criteria03;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreReplyMapper {
    public void insert(StoreReplyDto storeReplyDto);
    public List<StoreReplyDto> selectList(Long storeNumber);
    public StoreReplyDto select(Long storeReplyNumber);
    public void update(StoreReplyDto storeReplyDto);
    public void delete(Long storeReplyNumber);
    public List<StoreReplyDto> selectListPage(@Param("criteria")Criteria03 criteria03, @Param("storeNumber") Long storeNumber);
    public int replyTotal(Long storeNumber);
    public int replyAvg(Long storeNumber);
}
