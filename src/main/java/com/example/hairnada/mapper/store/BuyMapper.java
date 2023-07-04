package com.example.hairnada.mapper.store;

import com.example.hairnada.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyMapper {
    // 회원 정보 가져오기
    public UserDto selectUser(Long userNumber);

    // 장바구니에서 선택한 정보 가져오기
}
