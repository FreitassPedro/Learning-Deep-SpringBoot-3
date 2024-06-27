package com.pedro.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": Executando DB - Adding an MEMBERSHIP");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": doToSleep() Zzzzz");
    }
}
