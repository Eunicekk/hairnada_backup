package com.example.hairnada.mapper.admin;

import com.example.hairnada.dto.hair.HairFileDto;
import com.example.hairnada.dto.store.StoreFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFileMapper {
    // 헤어스타일 파일 업로드
    public void insertHairFile(HairFileDto hairFileDto);

    // 헤어스타일 파일 조회
    public List<HairFileDto> selectHairList(Long hairNumber);

    // 헤어스타일 파일 삭제
    public void deleteHairFile(Long hairNumber);

    // 스토어 파일 업로드
    public void insertStoreFile(StoreFileDto storeFileDto);

    // 상품 사진 불러오기
    public List<StoreFileDto> selectStoreList(Long storeNumber);

    // 상품 파일 삭제
    public void deleteStoreFile(Long storeNumber);
}
