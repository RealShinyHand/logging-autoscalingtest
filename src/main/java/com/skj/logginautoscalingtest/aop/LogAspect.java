package com.skj.logginautoscalingtest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("execution(public * com.skj.logginautoscalingtest.api..*(..))")
    public void controllerPointCut(){}


    @Around("controllerPointCut()")
    public void methodExcecutionTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
//출처 : https://velog.io/@dhk22/Spring-AOP-%EA%B0%84%EB%8B%A8%ED%95%9C-AOP-%EC%A0%81%EC%9A%A9-%EC%98%88%EC%A0%9C-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%8B%A4%ED%96%89%EC%8B%9C%EA%B0%84-%EC%B8%A1%EC%A0%95
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        joinPoint.proceed(); // 조인포인트의 메서드 실행
        stopWatch.stop();

        long totalTimeMillis = stopWatch.getTotalTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();

        log.info("실행 메서드: {}, 실행시간 = {}ms", methodName, totalTimeMillis);

    }




}
