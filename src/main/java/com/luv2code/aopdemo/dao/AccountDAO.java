package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getServiceName();

    void setServiceName(String serviceName);

    String getName();

    void setName(String name);
}
