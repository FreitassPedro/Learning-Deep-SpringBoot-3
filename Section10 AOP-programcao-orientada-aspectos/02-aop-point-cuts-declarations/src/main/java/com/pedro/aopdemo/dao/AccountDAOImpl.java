package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // create sample account and add them to our list
        myAccounts.add(new Account("John", "Silver"));
        myAccounts.add(new Account("Mahs", "Platinum"));
        myAccounts.add(new Account("Lucca", "Challenger"));

        return myAccounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Executando DB - Adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");

        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");

        this.serviceCode = serviceCode;
    }
}
