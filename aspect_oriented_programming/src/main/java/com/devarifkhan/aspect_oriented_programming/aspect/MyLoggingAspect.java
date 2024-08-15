package com.devarifkhan.aspect_oriented_programming.aspect;

import com.devarifkhan.aspect_oriented_programming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    // add a new advice for @AfterReturning on the find accounts method
   @AfterReturning(pointcut = "execution(* com.devarifkhan.aspect_oriented_programming.dao.AccountDAO.findAccounts(..))", returning = "result")
public void addAfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
    System.out.println("\n=====>>> Executing @AfterReturning advice on findAccounts()");
    String method= theJoinPoint.getSignature().toShortString();
       System.out.println("\n======> @AfterReturning advice on findAccounts");
       System.out.println("Method: "+method);
       System.out.println("Returned result: "+result);
       System.out.println("======");


}


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
