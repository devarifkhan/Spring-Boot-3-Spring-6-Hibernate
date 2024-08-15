package com.devarifkhan.aspect_oriented_programming.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyLoggingAspect {


    @Before("com.devarifkhan.aspect_oriented_programming.aspect.DevArifAopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        // display the method signature
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);
        // display method arguments
        Object[] args=theJoinPoint.getArgs();
    }








}
