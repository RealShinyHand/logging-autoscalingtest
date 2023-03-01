package com.skj.logginautoscalingtest.service;

import com.skj.logginautoscalingtest.dto.Memo;
import com.skj.logginautoscalingtest.dto.PageDto;
import com.skj.logginautoscalingtest.mapper.MemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final MemoMapper memoMapper;

    Optional<Memo> selectOne(long id){
        return memoMapper.selectOne(id);
    }

    List<Memo> selectByWriterIP(String writerIP){
        return memoMapper.selectByWriterIP(writerIP);
    }
    List<Memo> selectByServerIP(String serverIP){
        return memoMapper.selectByServerIP(serverIP);
    }
    List<Memo> selectPaging(PageDto pageDto){

        return memoMapper.selectPaging(pageDto);
    }

    int insertOne(Memo memo){
        return memoMapper.insertOne(memo);
    }
}
