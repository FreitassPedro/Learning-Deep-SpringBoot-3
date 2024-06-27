package com.pedro.aopdemo.aspect;

import com.pedro.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @After("execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theException")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theException) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n====>>> The exception is: " + theException);

    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "output")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
                                                 List<Account> output) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @AfterReturning on method: " + method);

        // let's modify post-process data
        convertAccountNamesToUpperCase(output);

        // print out the results of the method call
        System.out.println("\n====>> result is: " + output);
    }

    private List<Account> convertAccountNamesToUpperCase(List<Account> output) {
        for (Account acc : output) acc.setName(acc.getName().toUpperCase());
        return output;
    }


    @Before("com.pedro.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // display method arguments
        System.out.println("Method: " + methodSignature);

        // display arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("account name: " + theAccount.getName() + " || account level: " + theAccount.getLevel());

            }
        }
    }


}
