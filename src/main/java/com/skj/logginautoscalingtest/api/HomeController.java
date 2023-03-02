package com.skj.logginautoscalingtest.api;

import com.skj.logginautoscalingtest.domain.Memo;
import com.skj.logginautoscalingtest.domain.PageInfo;
import com.skj.logginautoscalingtest.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;


    @GetMapping("")
    public String test(){
        return "server ok";
    }

    @GetMapping("/memos")
    public PageInfo<?> getMemos(@RequestParam(required = false,name = "index") Integer index){
        if(index == null){
            index = 1;
        }
        return homeService.selectPaging(index);
    }

    @GetMapping("/serverIp/memos")
    public List<Memo> getServerIPMemos(@RequestParam(required = false) String serverIp,@RequestParam(required = false) String writerIP)
    {
        return homeService.selectByServerIP();
    }

    @GetMapping("/writerIp/memos")
    public List<Memo> getWriterIPMemos(@RequestParam(required = true) String writerIP)
    {
        return homeService.selectByWriterIP(writerIP);
    }

    @GetMapping("/memos/{id}")
    public Memo getMemoById(@PathVariable(name = "id")Long id){
        Memo memo = homeService.selectOne(id);

        if(memo == null){
            throw new RuntimeException("해당 id를 가진 Memo를 찾을 수 없습니다.");
        }

        return memo;
    }

    @PostMapping("/memos")
    public Map<String,Object> insetMemo( @RequestBody Memo memo, HttpServletRequest req){
        memo.setWriterIP(req.getRequestedSessionId());
        int result =homeService.insertOne(memo);
        Map<String,Object> map = new HashMap<>();

        map.put("responseCode",result);
        map.put("message",result == 1 ? "정상적으로 등록되었습니다.":"메모 등록에 실패하였습니다.");
        return map;
    }

}
