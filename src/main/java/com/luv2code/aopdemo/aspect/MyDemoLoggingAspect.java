package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====> result is: " + result);

        convertToUpperCase(result);

        System.out.println("\n=====> result is: " + result);
    }

    private void convertToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }


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
