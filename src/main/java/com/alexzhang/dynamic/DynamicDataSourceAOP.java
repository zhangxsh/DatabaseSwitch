package com.alexzhang.dynamic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by alexzhang on 2017/12/16.
 */
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAOP {


    @Pointcut("@annotation(com.alexzhang.dynamic.TargetDataSource)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        com.alexzhang.dynamic.DataSourceContextHolder.setDataSource(method.getAnnotation(com.alexzhang.dynamic.TargetDataSource.class).type());
    }

    @After("pointCut()")
    public void after(){
        com.alexzhang.dynamic.DataSourceContextHolder.setDataSource(Type.DEFAULT);
    }
}
