package com.skj.logginautoscalingtest.mapper;

import com.skj.logginautoscalingtest.domain.Memo;
import com.skj.logginautoscalingtest.domain.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemoMapper {

    Optional<Memo> selectOne(long id);
    List<Memo> selectByWriterIP(String writerIP);
    List<Memo> selectByServerIP(String serverIP);
    List<Memo> selectPaging(PageDto pageDto);
    int insertOne(Memo memo);
    Long count();
}
