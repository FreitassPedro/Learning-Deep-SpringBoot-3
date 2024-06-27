package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
