package com.devarifkhan.aspect_oriented_programming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DevArifAopExpressions {
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

}
