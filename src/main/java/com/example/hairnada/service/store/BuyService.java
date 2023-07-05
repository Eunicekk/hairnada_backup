package com.example.hairnada.service.store;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.store.BuyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuyService {
    @Autowired
    private BuyMapper buyMapper;

    // 회원 정보 조회하기
    @Transactional(readOnly = true)
    public UserDto findUser(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호가 없습니다.");
        }
        return Optional.ofNullable(buyMapper.selectUser(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원 정보입니다.");});
    }
}
