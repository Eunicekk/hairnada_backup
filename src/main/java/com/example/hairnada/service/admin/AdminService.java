package com.example.hairnada.service.admin;

import com.example.hairnada.dto.user.UserDto;
import com.example.hairnada.mapper.admin.AdminMapper;
import com.example.hairnada.vo.level.LevelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;

    // 회원 전체 조회
    public List<UserDto> findUserList(){
        return adminMapper.selectUserList();
    }

    // 등업 게시글 목록 조회
    public List<LevelVo> findLevelList() {return adminMapper.selectLevelList();}

}
