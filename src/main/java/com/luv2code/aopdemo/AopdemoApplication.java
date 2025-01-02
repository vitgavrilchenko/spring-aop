package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
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
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
                                               MembershipDAO membershipDAO,
                                               TrafficFortuneService trafficFortuneService) {
        return _ ->
                //demoTheBeforeAdvice(theAccountDAO, membershipDAO);
                //demoTheAfterReturningAdvice(theAccountDAO);
                //demoTheAfterThrowingAdvice(theAccountDAO);

        //demoTheAfterAdvice(theAccountDAO);

        //demoTheAroundAdvice(trafficFortuneService);
        //demoTheAroundAdviceHandleException(trafficFortuneService);
        demoTheAroundAdviceHandleExceptionReThrowExc(trafficFortuneService);
    }

    private void demoTheAroundAdviceHandleExceptionReThrowExc(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceHandleExceptionReThrowExc");
        System.out.println("Calling getFortune()");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
        System.out.println("Calling getFortune()");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling getFortune()");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
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