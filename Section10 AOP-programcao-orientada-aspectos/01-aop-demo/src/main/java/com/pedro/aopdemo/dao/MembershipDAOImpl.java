package com.pedro.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": Executando DB - Adding an MEMBERSHIP");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": doToSleep() Zzzzz");
    }
}
