package com.devarifkhan.aspect_oriented_programming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
//    @Before("execution(public void add*())")
@Before("execution(* add*(com.devarifkhan.aspect_oriented_programming.Account,..))")
public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
