package com.example.hairnada.service.level;

import com.example.hairnada.dto.level.LevelFileDto;
import com.example.hairnada.dto.user.UserFileDto;
import com.example.hairnada.mapper.level.LevelFileMapper;
import com.example.hairnada.mapper.user.UserFileMapper;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LevelFileService {
    private final LevelFileMapper levelFileMapper;

    @Value("${file.dir}")
    private String fileDir;

    //    등록
    public void register(LevelFileDto levelFileDto){
        if(levelFileDto == null){ throw new IllegalArgumentException("파일 정보 없음");}
        levelFileMapper.insertFileTier(levelFileDto);
    }

    //    삭제
    public void remove(Long levelNumber){
        if (levelNumber == null){
            throw new IllegalArgumentException("게시물 번호 없음");
        }
        levelFileMapper.deleteFileTier(levelNumber);
    }

    //    읽어오기
    public LevelFileDto findList(Long levelNumber){
        return levelFileMapper.selectFileTier(levelNumber);
    }

    //    파일 저장
    public LevelFileDto saveFile(MultipartFile file) throws IOException {
        //        사용자가 올린 파일 이름(확장자를 포함)
        String originName = file.getOriginalFilename();
        // 파일 이름에 공백이 들어오면 처리해준다.
        originName = originName.replaceAll("\\s+", "");

//        파일 이름에 붙여줄 uuid 생성(파일이름 중복이 나오지 않게 처리)
        UUID uuid = UUID.randomUUID();

//        uuid와 파일이름을 합쳐준다.
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(fileDir, getUploadPath());

//        경로가 존재하지 않는다면(폴더가 없다면)
        if(!uploadPath.exists()){
//            경로에 필요한 폴더를 생성한다.
            uploadPath.mkdirs();
        }

//        전체 경로와 파일이름을 연결한다.
        File uploadFile = new File(uploadPath, sysName);

//        매개변수로 받은 파일을 우리가 만든 경로와 이름으로 저장한다.
//        transferTo(경로)
//        MultipartFile객체를 실제로 저장시킨다.
//        저장시킬 경로와 이름을 매개변수로 넘겨주면 된다.
        file.transferTo(uploadFile);

//        썸네일 저장처리
//        이미지 파일인 경우에만 처리하는 조건식
        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_"+sysName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 300, 200);
            out.close();
        }

//        boardNumber를 제외한 모든 정보를 가진 FileDto를 반환한다.
        LevelFileDto levelFileDto = new LevelFileDto();
        levelFileDto.setLevelFileUuid(uuid.toString());
        levelFileDto.setLevelFileName(originName);
        levelFileDto.setLevelFileUploadPath(getUploadPath());

        return levelFileDto;

    }

    /**
     * 파일 리스트를 DB등록 및 저장 처리
     *
     * @param file 파일을 담은 리스트
     * @param levelNumber 파일이 속하는 회원 번호
     * @throws IOException
     */
    public void registerAndSaveFiles(MultipartFile file, Long levelNumber) throws IOException{
        LevelFileDto levelFileDto = saveFile(file);

        levelFileDto.setLevelFileNumber(levelNumber);
        register(levelFileDto);
    }



    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
