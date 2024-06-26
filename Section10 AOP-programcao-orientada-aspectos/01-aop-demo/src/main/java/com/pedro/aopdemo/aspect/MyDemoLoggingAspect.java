package com.pedro.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before("execution(void add*())
    // @Before("execution(* add*())
    // @Before("execution(void add*(com.pedro.aopdemo.dao.Account))")
    @Before("execution(* com.pedro.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===>> Executing @Before advice on addAccount()");
    }


}
