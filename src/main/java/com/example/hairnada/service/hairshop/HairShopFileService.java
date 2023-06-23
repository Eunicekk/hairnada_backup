package com.example.hairnada.service.hairshop;

import com.example.hairnada.dto.hairshop.HairShopFileDto;
import com.example.hairnada.mapper.hairshop.HairShopFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HairShopFileService {
    private final HairShopFileMapper hairShopFileMapper;

    // application.properties에 저장해둔 file.dir 프로퍼티 값을 가져온다.
    @Value("${file.dir}")
    private String fileDir;

    // 게시물 리스트 파일 띄우기
    public List<HairShopFileDto> findList(Long hairShopNumber){
        return hairShopFileMapper.selectList(hairShopNumber);
    }


}
