package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void fotDaoPackage() {
    }

    @Before("fotDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on method");
    }

    @Before("fotDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("====>>> Performing API analytics");
    }

}
