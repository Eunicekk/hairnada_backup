package com.example.hairnada.service.careshop;

import com.example.hairnada.dto.careshop.CareShopDto;
import com.example.hairnada.mapper.careshop.CareShopMapper;
import com.example.hairnada.service.careshop.CareShopFileService;
import com.example.hairnada.vo.careshop.CareShopVo;
import com.example.hairnada.vo.page.Criteria03;
import com.example.hairnada.vo.page.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareShopService {
    private final CareShopMapper careShopMapper;
    private final CareShopFileService careShopFileService;

    //  전제 조회
    @Transactional(readOnly = true)
    public List<CareShopVo> findAll(Criteria03 criteria03){
        return careShopMapper.selectAll(criteria03);
    }

    // 전체 게시물 수
    @Transactional(readOnly = true)
    public int getTotal(){
        return careShopMapper.selectTotal();
    }

    // 게시물 한개 조회
    @Transactional(readOnly = true)
    public CareShopVo findCareShop(Long careShopNumber){
        if(careShopNumber == null){
            throw new IllegalArgumentException("헤어샵 번호가 없습니다.");
        }
        return Optional.ofNullable(careShopMapper.select(careShopNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("헤어샵 번호가 존재하지 않습니다.");});
    }

    // 게시물 추가
    public void register(CareShopDto careShopDto){
        if(careShopDto == null){
            throw new IllegalArgumentException("헤어샵 정보가 없습니다.");
        }
        careShopMapper.insert(careShopDto);
    }

    // 게시물 삭제
    public void remove(Long careShopNumber){
        if(careShopNumber == null){
            throw new IllegalArgumentException("헤어샵이 존재하지 않습니다.");
        }
        careShopMapper.delete(careShopNumber);
        careShopFileService.remove(careShopNumber);
    }

    // 게시물 수정
    public void modify(CareShopDto careShopDto){
        if(careShopDto == null){
            throw new IllegalArgumentException("헤어샵 수정 정보가 없습니다.");
        }
        careShopMapper.update(careShopDto);
    }

    // 게시물 수정 (파일 처리 포함)
    public void modify(CareShopDto careShopDto, List<MultipartFile> files) throws IOException {
        if(careShopDto == null || files == null){
            throw new IllegalArgumentException("헤어샵 수정 매개변수의 null 체크가 필요합니다.");
        }
        careShopFileService.remove(careShopDto.getCareShopNumber());
        careShopFileService.registerAndSaveFiles(files, careShopDto.getCareShopNumber());
        careShopMapper.update(careShopDto);
    }

    // 게시물 검색
    public List<CareShopVo> search(Criteria03 criteria03, SearchVo searchVo){
        if(searchVo == null){
            throw new IllegalArgumentException("입력한 헤어샵 키워드가 없습니다.");
        }
        return careShopMapper.search(criteria03, searchVo);
    }

    // 게시물 검색 개수
    @Transactional(readOnly = true)
    public int searchTotal(SearchVo searchVo){
        return careShopMapper.searchTotal(searchVo);
    }
}
