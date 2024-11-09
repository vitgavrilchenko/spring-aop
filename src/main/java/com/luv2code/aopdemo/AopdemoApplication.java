package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
        return _ ->
                //demoTheBeforeAdvice(theAccountDAO, membershipDAO);
                //demoTheAfterReturningAdvice(theAccountDAO);
                //demoTheAfterThrowingAdvice(theAccountDAO);

        demoTheAfterAdvice(theAccountDAO);
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program: .... caught exc: " + e);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = true;
            accounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program: .... caught exc: " + e);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");

        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();
        theAccountDAO.setName("fooBar");
        theAccountDAO.setServiceName("silver");

        String name = theAccountDAO.getName();
        String serviceName = theAccountDAO.getServiceName();

        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

    }

}