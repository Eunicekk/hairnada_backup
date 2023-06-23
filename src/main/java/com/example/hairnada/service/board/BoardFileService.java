package com.example.hairnada.service.board;


import com.example.hairnada.dto.board.BoardFileDto;
import com.example.hairnada.mapper.board.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardFileService {
    private final BoardFileMapper boardFileMapper;

    @Value("${file.dir}")
    private String fileDir;

    public void register(BoardFileDto boardFileDto){
        if(boardFileDto == null){ throw new IllegalArgumentException("파일 정보 없음");}
        boardFileMapper.insert(boardFileDto);
    }

    public void remove(Long boardNumber){
        if (boardNumber == null){
            throw new IllegalArgumentException("게시물 번호 없음");
        }
        boardFileMapper.delete(boardNumber);
    }

    public List<BoardFileDto> findList(Long boardNumber){
        return boardFileMapper.selectList(boardNumber);
    }

//    파일 저장
    public BoardFileDto saveFile(MultipartFile file) throws IOException{
        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(fileDir, getUploadPath());

        if (!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        File uploadFile = new File(uploadPath, sysName);

        file.transferTo(uploadFile);

        if (Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_"+sysName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 416, 250);
            out.close();
        }

        BoardFileDto boardFileDto = new BoardFileDto();
        boardFileDto.setBoardFileUuid(uuid.toString());
        boardFileDto.setBoardFileName(originName);
        boardFileDto.setBoardFileUploadPath(getUploadPath());

        return boardFileDto;
    }

    public void registerAndSaveFiles(List<MultipartFile> files, Long boardNumber) throws IOException{
        for (MultipartFile file : files){
            BoardFileDto boardFileDto = saveFile(file);
            boardFileDto.setBoardNumber(boardNumber);
            register(boardFileDto);
        }
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
