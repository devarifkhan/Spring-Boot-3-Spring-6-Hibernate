package com.devarifkhan.aspect_oriented_programming;

import com.devarifkhan.aspect_oriented_programming.dao.AccountDAO;
import com.devarifkhan.aspect_oriented_programming.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO ) {
        return runner -> {
            TheBeforeAdvice(theAccountDAO,theMembershipDAO);
        };
    }

    private void TheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call the business method
        Account myAccount = new Account();
        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();

        //call teh accountdao getter/ setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");
        System.out.println(theAccountDAO.getName());
        System.out.println(theAccountDAO.getServiceCode());


        //call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();





    }
}
