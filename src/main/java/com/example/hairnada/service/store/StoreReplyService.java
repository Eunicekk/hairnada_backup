package com.example.hairnada.service.store;

import com.example.hairnada.dto.board.BoardReplyDto;
import com.example.hairnada.dto.store.StoreReplyDto;
import com.example.hairnada.mapper.store.StoreReplyMapper;
import com.example.hairnada.vo.page.Criteria03;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreReplyService {
    private final StoreReplyMapper storeReplyMapper;

    public void register(StoreReplyDto storeReplyDto){
        System.out.println(storeReplyDto);
        if (storeReplyDto == null){
            throw new IllegalArgumentException("댓글 정보 누락");
        }
        storeReplyMapper.insert(storeReplyDto);
    }

    public List<StoreReplyDto> findList(Long storeNumber){
        if (storeNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return storeReplyMapper.selectList(storeNumber);
    }

    public StoreReplyDto findStoreReply(Long storeReplyNumber){
        if (storeReplyNumber == null){
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        return Optional.ofNullable(storeReplyMapper.select(storeReplyNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 댓글입니둥");});
    }

    public void modify(StoreReplyDto storeReplyDto){
        if (storeReplyDto == null){
            throw new IllegalArgumentException("댓글 수정정보 누락");
        }
        storeReplyMapper.update(storeReplyDto);
    }

    public void remove(Long storeReplyNumber){
        if (storeReplyNumber == null){
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        storeReplyMapper.delete(storeReplyNumber);
    }

    public List<StoreReplyDto> findListPage(Criteria03 criteria03, Long storeNumber){
        if (criteria03 == null || storeNumber == null){
            throw new IllegalArgumentException("댓글 페이징 정보 누락");
        }
        return storeReplyMapper.selectListPage(criteria03, storeNumber);
    }

    public int findTotal(Long storeNumber){
        if (storeNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return storeReplyMapper.selectTotal(storeNumber);
    }

    public float replyAvg(Long storeNumber){
        if (storeNumber == null){
            throw new IllegalArgumentException("누락");
        }
        return storeReplyMapper.replyAvg(storeNumber);
    }
}
