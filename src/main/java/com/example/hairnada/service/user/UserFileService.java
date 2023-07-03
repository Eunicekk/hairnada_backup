package com.example.hairnada.service.user;

import com.example.hairnada.dto.board.BoardFileDto;
import com.example.hairnada.dto.user.UserFileDto;
import com.example.hairnada.mapper.user.UserFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
@Slf4j
public class UserFileService {
    private final UserFileMapper userFileMapper;

    @Value("${file.dir}")
    private String fileDir;

    public void register(UserFileDto userFileDto){
        if(userFileDto == null){ throw new IllegalArgumentException("파일 정보 없음");}
        userFileMapper.insertUserFile(userFileDto);
    }

    public void remove(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("게시물 번호 없음");
        }
        userFileMapper.deleteUserFile(userNumber);
    }

    public UserFileDto findList(Long userNumber){
        return userFileMapper.selectUserFile(userNumber);
    }

    //    파일 저장
    public UserFileDto saveFile(MultipartFile file) throws IOException{
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

        UserFileDto userFileDto = new UserFileDto();
        userFileDto.getUserFileUuid();
        userFileDto.setUserFileName(originName);
        userFileDto.getUserFileUploadPath();

        return userFileDto;
    }

    public void registerAndSaveFiles(List<MultipartFile> files, Long userNumber) throws IOException{
        for (MultipartFile file : files){
            UserFileDto userFileDto = saveFile(file);
            userFileDto.setUserNumber(userNumber);
            register(userFileDto);
        }
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
