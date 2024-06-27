package com.pedro.aopdemo.aspect;

import com.pedro.aopdemo.Account;
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
public class MyDemoLoggingAspect {

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

            if(arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("account name: " + theAccount.getName() + " || account level: " + theAccount.getLevel());

            }
        }
    }






}
