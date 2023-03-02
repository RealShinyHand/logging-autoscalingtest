package com.skj.logginautoscalingtest.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class PageInfo<T> {
    private List<T> data;
    private int totalPageNumber;
    private int prevIndex;
    private int nextIndex;
    private long totalCount;

    private PageInfo() {}

    public static <T> PageInfoBuilder<T> builder() {
        return new PageInfoBuilder<T>();
    }

    public static class PageInfoBuilder<T> {
        private PageInfo<T> pageInfo;

        private PageInfoBuilder() {
            pageInfo = new PageInfo<>();
        }

        public PageInfoBuilder<T> data(List<T> data) {
            pageInfo.data = data;
            return this;
        }

        public PageInfoBuilder<T> totalPageNumber(int totalPageNumber) {
            pageInfo.totalPageNumber = totalPageNumber;
            return this;
        }

        public PageInfoBuilder<T> prevIndex(int prevIndex) {
            pageInfo.prevIndex = prevIndex;
            return this;
        }

        public PageInfoBuilder<T> nextIndex(int nextIndex) {
            pageInfo.nextIndex = nextIndex;
            return this;
        }

        public PageInfoBuilder<T> totalCount(long totalCount) {
            pageInfo.totalCount = totalCount;
            return this;
        }

        public PageInfo<T> build() {
            return pageInfo;
        }

    }
}
