package com.atguigu.servicebase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//1.切面类
@Aspect
@Slf4j
@Component
public class LogPrintAspect {

    //2.PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
    //logPointCut()代表切点名称
    @Pointcut("@annotation(com.atguigu.servicebase.annotation.LogPrint)")
    public void logPointCut() {
    }

    //3.环绕通知
    @Around("logPointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) {
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取入参
        Object[] param = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for (Object o : param) {
            sb.append(o + "; ");
        }
        String s = sb.toString();
        if ("".equals(s)){
            s="empty";
        }
        log.info("open [" + methodName + "] method, param:" + s);

        //继续执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info(methodName + " method implement end");
    }
}