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

        for(Object arg:args){
            System.out.println(arg);
            if(arg instanceof com.devarifkhan.aspect_oriented_programming.Account){
                com.devarifkhan.aspect_oriented_programming.Account account=(com.devarifkhan.aspect_oriented_programming.Account) arg;
                System.out.println("Account name: "+account.getName());
                System.out.println("Account level: "+account.getLevel());
            }
        }
    }








}
