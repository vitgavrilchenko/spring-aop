package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
        return _ -> demoTheBeforeAdvice(theAccountDAO, membershipDAO);
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();

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
