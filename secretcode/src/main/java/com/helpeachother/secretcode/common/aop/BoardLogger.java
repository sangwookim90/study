package com.helpeachother.secretcode.common.aop;

import com.helpeachother.secretcode.log.service.LogService;
import com.helpeachother.secretcode.user.entity.User;
import com.helpeachother.secretcode.user.model.UserLogin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Aspect
@Component
public class BoardLogger {

    private final LogService logService;

    @Around("execution(* com.helpeachother.secretcode..*.*Controller.detail(..))")
    public Object log(ProceedingJoinPoint joinPoint)  throws Throwable {
        log.info("#############################");
        log.info("#############################");
        log.info("컨트롤러 detail 호출 전!!!!");

        Object result = joinPoint.proceed();

//        if("ApiBoardController".equals(joinPoint.getSignature().getDeclaringTypeName())
        if(joinPoint.getSignature().getDeclaringTypeName().contains("ApiBoardController")
                && "detail".equals(joinPoint.getSignature().getName())) {

            StringBuilder sb = new StringBuilder();
            sb.append("파라미터: ");
            Object[] args = joinPoint.getArgs();
            for(Object x : args) {
                sb.append(x.toString());
            }

            sb.append("결과:");
            sb.append(result.toString());

            logService.add(sb.toString());
            log.info(sb.toString());
        }

        log.info("#############################");
        log.info("#############################");
        log.info("컨트롤러 detail 호출 !!!!");

        return result;
    }
}
