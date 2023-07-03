package com.example.hairnada.controller.user;

import com.example.hairnada.dto.board.BoardFileDto;
import com.example.hairnada.dto.user.UserFileDto;
import com.example.hairnada.service.user.UserFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/userFile/*")
@RequiredArgsConstructor
public class UserFileController {
    private final UserFileService userFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/profileImg")
    public UserFileDto imgList(Long userNUmber){return userFileService.findList(userNUmber);}

    @GetMapping("/display")
    public byte[] display(String userFileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, userFileName));
    }

}
