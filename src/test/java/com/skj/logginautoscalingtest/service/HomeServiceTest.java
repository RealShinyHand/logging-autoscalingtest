package com.skj.logginautoscalingtest.service;

import com.skj.logginautoscalingtest.domain.Memo;
import com.skj.logginautoscalingtest.domain.PageInfo;
import com.skj.logginautoscalingtest.mapper.MemoMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@ActiveProfiles("test")
@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeServiceTest {

    @Autowired
    HomeService homeService;

    @Autowired
    MemoMapper memoMapper;
    @Test
    @Order(1)
    public void givenId_WhenSelectOne_ThenReturn(){
        Memo memo = homeService.selectOne(1L);

        Assertions.assertNotNull(memo);
    }

    @Test
    @Order(2)
    public void givenNoting_WhenCount_ThenReturn1(){
        Long count= memoMapper.count();
        Assertions.assertEquals(1L,count);
    }

    @Test
    @Order(3)
    public void givenMemo_whenInsertMemo_ThenReturn(){

        Memo memo = new Memo();
        memo.setMemo("ttt");
        memo.setWriterIP("173.3.1.2");
        int result = homeService.insertOne(memo);
        Assertions.assertEquals(1,result);
    }

    @Test
    @Order(4)
    public  void pagingTest(){
        PageInfo<Memo> memoPageInfo = homeService.selectPaging(1);
        Assertions.assertEquals(2,memoPageInfo.getData().size());
        Assertions.assertEquals(1,memoPageInfo.getNextIndex());
        Assertions.assertEquals(1,memoPageInfo.getPrevIndex());
        Assertions.assertEquals(2,memoPageInfo.getTotalCount());
        Assertions.assertEquals(1,memoPageInfo.getTotalPageNumber());
    }
}