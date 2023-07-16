package com.example.hairnada.service.test;

import com.example.hairnada.mapper.hairTest.HairTestMapper;
import com.example.hairnada.vo.hairTest.HairTestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final HairTestMapper hairTestMapper;

    public List<HairTestVo> testResult(List<Integer> resultList){
//        int[] arr = new int[6];
//
//        int count = 0;
////        resultList.get(0) ==1
//
//        if(resultList.get(0) == 1){
//            count++;
//        }else if(resultList.get(1) == 1){
//            count++;
//        }

        int eggFace = 0;
        int longFace = 0;
        int roundFace = 0;
        int triangleFace = 0;
        int sixFace = 0;
        int squareFace = 0;

        if(resultList.get(1) == 1){
            eggFace++;
            longFace++;
            roundFace++;
        }else {
            triangleFace++;
            sixFace++;
            squareFace++;
        }
        if(resultList.get(2) == 1){
            eggFace++;
            roundFace++;
            sixFace++;
            squareFace++;
        }else {
            longFace++;
            triangleFace++;
        }
        if(resultList.get(3) == 1){
            eggFace++;
            roundFace++;
            longFace++;
            triangleFace++;
        }else {
            sixFace++;
            squareFace++;
        }
        if(resultList.get(4) == 0){
            sixFace++;
            triangleFace++;
        }else if(resultList.get(4) == 1){
            eggFace++;
            roundFace++;
        }else {
            longFace++;
            squareFace++;
        }
        if(resultList.get(5) == 1){
            triangleFace++;
            sixFace++;
            squareFace++;
        }else {
            eggFace++;
            roundFace++;
            longFace++;
        }


        int maxCount = Math.max(eggFace, Math.max(longFace, Math.max(roundFace, Math.max(triangleFace, Math.max(sixFace, squareFace)))));


        Long shapeNumber = 0L;
        if (maxCount == eggFace) {
           shapeNumber = 1L;
        } else if (maxCount == longFace) {
            shapeNumber = 2L;

        } else if (maxCount == roundFace) {
            shapeNumber = 3L;

        } else if (maxCount == triangleFace) {
            shapeNumber = 4L;

        } else if (maxCount == sixFace) {
            shapeNumber = 5L;

        } else {
            shapeNumber = 6L;
        }

        return hairTestMapper.selectTestResult(shapeNumber, resultList.get(0) == 0 ? "M" : "F");

    }
}
