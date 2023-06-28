package com.example.hairnada.service.hairshop;

import com.example.hairnada.dto.hairshop.HairShopDto;
import com.example.hairnada.mapper.hairshop.HairShopMapper;
import com.example.hairnada.vo.page.SearchVo;
import com.example.hairnada.vo.hairshop.HairShopVo;
import com.example.hairnada.vo.page.Criteria03;
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
public class HairShopService {
    private final HairShopMapper hairShopMapper;
    private final HairShopFileService hairShopFileService;

    //  전제 조회
    @Transactional(readOnly = true)
    public List<HairShopVo> findAll(Criteria03 criteria03){
        return hairShopMapper.selectAll(criteria03);
    }

    // 전체 게시물 수
    @Transactional(readOnly = true)
    public int getTotal(){
        return hairShopMapper.selectTotal();
    }

    // 게시물 한개 조회
    @Transactional(readOnly = true)
    public HairShopVo findHairShop(Long hairShopNumber){
        if(hairShopNumber == null){
            throw new IllegalArgumentException("헤어샵 번호가 없습니다.");
        }
        return Optional.ofNullable(hairShopMapper.select(hairShopNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("헤어샵 번호가 존재하지 않습니다.");});
    }

    // 게시물 추가
    public void register(HairShopDto hairShopDto){
        if(hairShopDto == null){
            throw new IllegalArgumentException("헤어샵 정보가 없습니다.");
        }
        hairShopMapper.insert(hairShopDto);
    }

    // 게시물 삭제
    public void remove(Long hairShopNumber){
        if(hairShopNumber == null){
            throw new IllegalArgumentException("헤어샵이 존재하지 않습니다.");
        }
        hairShopMapper.delete(hairShopNumber);
        hairShopFileService.remove(hairShopNumber);
    }

    // 게시물 수정
    public void modify(HairShopDto hairShopDto){
        if(hairShopDto == null){
            throw new IllegalArgumentException("헤어샵 수정 정보가 없습니다.");
        }
        hairShopMapper.update(hairShopDto);
    }

    // 게시물 수정 (파일 처리 포함)
    public void modify(HairShopDto hairShopDto, List<MultipartFile> files) throws IOException {
        if(hairShopDto == null || files == null){
            throw new IllegalArgumentException("헤어샵 수정 매개변수의 null 체크가 필요합니다.");
        }
        hairShopFileService.remove(hairShopDto.getHairShopNumber());
        hairShopFileService.registerAndSaveFiles(files, hairShopDto.getHairShopNumber());
        hairShopMapper.update(hairShopDto);
    }

    // 게시물 검색
    public List<HairShopVo> search(Criteria03 criteria03, SearchVo searchVo){
        if(searchVo == null){
            throw new IllegalArgumentException("입력한 헤어샵 키워드가 없습니다.");
        }
        return hairShopMapper.search(criteria03, searchVo);
    }

    // 게시물 검색 개수
    @Transactional(readOnly = true)
    public int searchTotal(SearchVo searchVo){
        return hairShopMapper.searchTotal(searchVo);
    }
}
