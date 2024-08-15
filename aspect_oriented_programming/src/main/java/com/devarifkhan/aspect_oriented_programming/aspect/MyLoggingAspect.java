package com.devarifkhan.aspect_oriented_programming.aspect;

import com.devarifkhan.aspect_oriented_programming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyLoggingAspect {



    @Around("execution(* com.devarifkhan.aspect_oriented_programming.service.*.getFortune(..))")

    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint
    ) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @Around on method: " + method);

        long begin= System.currentTimeMillis();
        Object result= null;

        try{
            result=theProceedingJoinPoint.proceed();

        }
        catch (Exception e){
            System.out.println("\n===> Executing @Around on method: " + method);
            System.out.println("\n===> Exception: " + e.getMessage());

            // rethrow exception
            throw e;
        }



        long end=System.currentTimeMillis();
        long duration=end-begin;

        System.out.println("\n===>Duration: "+duration/ 1000.0 +" seconds");
        return result;
    }


    @After("execution(* com.devarifkhan.aspect_oriented_programming.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @afterFinallyFindAccountsAdvice on method: " + method);

    }

    // add a pointcut for all methods in the com.devarifkhan.aspect_oriented_programming.dao package
    @AfterThrowing(
            pointcut = "execution(* com.devarifkhan.aspect_oriented_programming.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing on method: " + method);

        System.out.println("\n===> The Exception is: " + theExc);

    }

    // add a new advice for @AfterReturning on the find accounts method
    @AfterReturning(pointcut = "execution(* com.devarifkhan.aspect_oriented_programming.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void addAfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        System.out.println("\n=====>>> Executing @AfterReturning advice on findAccounts()");
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======> @AfterReturning advice on findAccounts");
        System.out.println("Method: " + method);
        System.out.println("Returned result: " + result);
        System.out.println("======");

        convertAccountNamesToUpperCase(result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String theUpperCase = account.getName().toUpperCase();
            account.setName(theUpperCase);
        }
    }


    @Before("com.devarifkhan.aspect_oriented_programming.aspect.DevArifAopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        // display the method signature
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof com.devarifkhan.aspect_oriented_programming.Account) {
                com.devarifkhan.aspect_oriented_programming.Account account = (com.devarifkhan.aspect_oriented_programming.Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }


}
