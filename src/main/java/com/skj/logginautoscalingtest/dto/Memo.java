package com.skj.logginautoscalingtest.dto;

public class Memo {
    private long id;
    private String memo;
    private String writerIP;
    private String serverIP;

    @Override
    public String toString() {
        return "Memo{" +
                "id=" + id +
                ", memo='" + memo + '\'' +
                ", writerIP='" + writerIP + '\'' +
                ", serverIP='" + serverIP + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setWriterIP(String writerIP) {
        this.writerIP = writerIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }
}
