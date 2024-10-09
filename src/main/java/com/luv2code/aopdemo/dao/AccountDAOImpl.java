package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceName;

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": Doing my db work: adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DoWork");
        return false;
    }

    public String getServiceName() {
        System.out.println(getClass() + ": getServiceName");
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        System.out.println(getClass() + ": setServiceName");
        this.serviceName = serviceName;
    }

    public String getName() {
        System.out.println(getClass() + ": getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName");
        this.name = name;
    }
}
