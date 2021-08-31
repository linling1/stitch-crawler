package com.linling.stitch.crawler.aop;


import com.linling.stitch.crawler.data.ResponseEntity;
import com.linling.stitch.crawler.exception.FetchException;
import com.linling.stitch.crawler.model.FetchApiRet;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.linling.stitch.crawler.common.ApiConstants.API_RET_CODE_FAIL;
import static com.linling.stitch.crawler.common.ApiConstants.API_RET_STATUS_FAIL_FOR_SERVER;

@Aspect
@Component
@Slf4j
public class ApiAspect {

    private Consumer<? extends Exception> printLog(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

        String args = Arrays.asList(joinPoint.getArgs()).stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(","));

        String methodName = methodSignature.getMethod().getDeclaringClass().getName() + "." + methodSignature.getMethod().getName();

        log.info(methodName + " . request : " + args);

        return e -> log.error(methodName + " error . request : " + args + " ; err : ", e);
    }

    @Around("execution(* com.linling.stitch.crawler.api.FetchController.*(..))")
    public Object apiAround(ProceedingJoinPoint proceedingJoinPoint) {

        Consumer printErrLog = printLog(proceedingJoinPoint);

        FetchApiRet ret = new FetchApiRet();
        try {
            ret = (FetchApiRet)proceedingJoinPoint.proceed();
        } catch (FetchException e) {
            printErrLog.accept(e);
            ret.setCode(API_RET_CODE_FAIL);
            ret.setStatus(e.getMessage());
        }catch (Throwable e) {
            printErrLog.accept(e);
            ret.setCode(API_RET_CODE_FAIL);
            ret.setStatus(API_RET_STATUS_FAIL_FOR_SERVER);
        }

        return ret;
    }


    @Around("execution(* com.linling.stitch.crawler.dao.HttpHandler.request(..))")
    public Object requestAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Consumer printErrLog = printLog(proceedingJoinPoint);

        try {
            ResponseEntity ret = (ResponseEntity)proceedingJoinPoint.proceed();
            log.info("fetch request opt success. url : {} ; real url : {} ; fetch status : {} ; http code : {} ; proxy : {} ; cost : {} ; proto : {} ", ret.getRequestEntity().getUrl(), ret.getRealUrl(), ret.getStatus().getMsg(), ret.getHttpCode(), ret.getProxy(), ret.getCost(), ret.getProto());
            return ret;
        } catch (Throwable e) {
            printErrLog.accept(e);
            throw e;
        }

    }
}
