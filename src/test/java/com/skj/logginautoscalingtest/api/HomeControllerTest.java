package com.skj.logginautoscalingtest.api;

import com.skj.logginautoscalingtest.domain.Memo;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired(required = true)
    MockMvc mockMvc;

    @Test
    @Order(1)
    public void getMemos()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/home/memos").param("index", String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        ;
    }



}