package com.pedro.aopdemo.dao;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
