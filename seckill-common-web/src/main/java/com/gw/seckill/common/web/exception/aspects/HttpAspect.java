package com.gw.seckill.common.web.exception.aspects;

import com.gw.seckill.common.web.exception.handler.WebGlobalExceptionHandler;
import com.gw.seckill.common.web.exception.pojo.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
/**
　* @描述:     切面类,AOP切面，记录方法的调用，入参以及出參
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/5 15:13
  */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private WebGlobalExceptionHandler webGlobalExceptionHandler;

    @Pointcut("execution(public * com.gw.seckill.web.*.controller.*.*(..))")
//  @Pointcut("@annotation(logOnly)")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}",request.getRequestURL());
        //method
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("id={}",request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return webGlobalExceptionHandler.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        LOGGER.info("response={}",object.toString());
    }
}