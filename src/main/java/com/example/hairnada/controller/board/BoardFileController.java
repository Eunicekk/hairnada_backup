package com.example.hairnada.controller.board;

import com.example.hairnada.dto.board.BoardFileDto;
import com.example.hairnada.service.board.BoardFileService;
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
@RequestMapping("/communityFile/*")
@RequiredArgsConstructor
public class BoardFileController {
    private final BoardFileService boardFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<BoardFileDto> imgList(Long boardNumber){return boardFileService.findList(boardNumber);}

    @GetMapping("/display")
    public byte[] display(String boardFileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File(fileDir, boardFileName));
    }



}
