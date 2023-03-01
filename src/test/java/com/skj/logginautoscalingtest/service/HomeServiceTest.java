package com.skj.logginautoscalingtest.service;

import com.skj.logginautoscalingtest.dto.Memo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest()
class HomeServiceTest {

    @Autowired
    HomeService homeService;

    @Test
    public void test(){
        Optional<Memo> memo = homeService.selectOne(1L);

        Assertions.assertNotNull(memo);
    }
}