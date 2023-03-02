package com.skj.logginautoscalingtest.domain;

import lombok.Getter;

@Getter
public class PageDto {

    public PageDto(long start,int size){
        this.start = start;
        this.size = size;
    }
    private long start;
    private int size;
}
