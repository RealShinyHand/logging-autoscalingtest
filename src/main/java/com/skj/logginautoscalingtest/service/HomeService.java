package com.skj.logginautoscalingtest.service;

import com.skj.logginautoscalingtest.domain.Memo;
import com.skj.logginautoscalingtest.domain.PageDto;
import com.skj.logginautoscalingtest.domain.PageInfo;
import com.skj.logginautoscalingtest.mapper.MemoMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeService {
    Logger log = LoggerFactory.getLogger(HomeService.class);
    private final MemoMapper memoMapper;
    private final IPUtil ipUtil;

    public Memo selectOne(long id){

        return memoMapper.selectOne(id).orElse(null);
    }

    public List<Memo> selectByWriterIP(String writerIP){
        return memoMapper.selectByWriterIP(writerIP);
    }
    public  List<Memo> selectByServerIP(){
        String serverIP = ipUtil.getServerIP();
        return memoMapper.selectByServerIP(serverIP);
    }

    @Transactional(readOnly = true)
    public PageInfo<Memo> selectPaging(int index){

        int size = 10;

        Long count = memoMapper.count();
        if(count == null){
            log.info("count method error");
            throw new RuntimeException("count method error");
        }

        long start = size * (index - 1);
        int totalPageNumber =(int)((count -1) / size + 1);
        int prevIndex = index <= 1 ? 1 : index - 1;
        int nextIndex = index >= totalPageNumber ? totalPageNumber : index + 1;

        PageDto pageDto = new PageDto(start,size);
        List<Memo> data = memoMapper.selectPaging(pageDto);


        return PageInfo.<Memo>builder()
                .totalPageNumber(totalPageNumber)
                .data(data)
                .prevIndex(prevIndex)
                .nextIndex(nextIndex)
                .totalCount(count)
                .build();
    }

    public int insertOne(Memo memo){
        memo.setServerIP(ipUtil.getServerIP());
        return memoMapper.insertOne(memo);
    }
}
