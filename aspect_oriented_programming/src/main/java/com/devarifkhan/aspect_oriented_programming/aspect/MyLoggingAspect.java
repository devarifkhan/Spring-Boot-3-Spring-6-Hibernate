package com.devarifkhan.aspect_oriented_programming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {


    @Pointcut("execution(* com.devarifkhan.aspect_oriented_programming.dao.*.*(..))")
    public void forDaoPackage() {

    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.devarifkhan.aspect_oriented_programming.dao.*.get*(..))")
    public void getter() {

    }

    //create a pointcut for setter methods
    @Pointcut("execution(* com.devarifkhan.aspect_oriented_programming.dao.*.set*(..))")
    public void setter() {

    }
    // create pointcut: include package .. exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {

    }





    //    @Before("execution(public void add*())")
    //    @Before("execution(* com.devarifkhan.aspect_oriented_programming.dao.*.*(..))")

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
