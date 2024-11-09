package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you");
        }
        List<Account> accountList = new ArrayList<>();

        Account temp1 = new Account("John", "Sliver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        accountList.add(temp1);
        accountList.add(temp2);
        accountList.add(temp3);


        return accountList;
    }
}
