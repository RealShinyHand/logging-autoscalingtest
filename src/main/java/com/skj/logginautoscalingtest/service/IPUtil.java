package com.skj.logginautoscalingtest.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.http.HttpRequest;

@Slf4j
@Component
public class IPUtil {

    private String ip = null;

    public String  getServerIP(){

        if(this.ip == null) {

            this.ip = "Unknown";
            try {
                this.ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.info("can't load server ip");
            }
            return this.ip;
        }
        return this.ip;
    }

    public String getClientIP(HttpServletRequest req){
        String ip = req.getRemoteAddr();
        return ip;
    }
}
