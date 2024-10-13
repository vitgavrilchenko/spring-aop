package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("====>>> Executing @Before advice on method");

        System.out.println("Method: " + joinPoint.getSignature());

        for (Object tempArg : joinPoint.getArgs()) {
            System.out.println(tempArg);

            if (tempArg instanceof Account account) {
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }


    }

}
