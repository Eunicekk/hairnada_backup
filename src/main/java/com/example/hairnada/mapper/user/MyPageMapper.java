package com.example.hairnada.mapper.user;

import com.example.hairnada.vo.board.BoardVo;
import com.example.hairnada.vo.page.Criteria03;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {

//    작성글 조회
    public List<BoardVo> myBoard(@Param("userNumber")Long userNumber, @Param("criteria")Criteria03 criteria03);

    //    전제 게시글 조회
    public int selectTotal(Long userNumber);

}
