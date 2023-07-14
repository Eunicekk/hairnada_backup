package com.example.hairnada.vo.main;

import com.example.hairnada.vo.hairVo.StoreVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class RandomProduct {
    List<StoreVo> category01 = new ArrayList<>();
    List<StoreVo> category02 = new ArrayList<>();
    List<StoreVo> category03 = new ArrayList<>();
    List<StoreVo> category04 = new ArrayList<>();
    List<StoreVo> category05 = new ArrayList<>();
    List<StoreVo> category06 = new ArrayList<>();
}
