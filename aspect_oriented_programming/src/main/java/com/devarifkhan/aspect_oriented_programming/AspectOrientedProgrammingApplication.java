package com.devarifkhan.aspect_oriented_programming;

import com.devarifkhan.aspect_oriented_programming.dao.AccountDAO;
import com.devarifkhan.aspect_oriented_programming.dao.MembershipDAO;
import com.devarifkhan.aspect_oriented_programming.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
//            TheBeforeAdvice(theAccountDAO,theMembershipDAO);

//            TheAfterReturningAdvice(theAccountDAO);
//            TheAfterThrowingAdvice(theAccountDAO);
//            TheAfterAdvice(theAccountDAO);

//            TheAroundAdvice(theTrafficFortuneService);

//            TheAroundAdviceHandleException(theTrafficFortuneService);
            theAroundAdviceRethrowException(theTrafficFortuneService);


        };
    }

    private void theAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\n Main Program: theAroundAdviceRethrowException");
        System.out.println("Calling getFortune");

        boolean tripWire=true;

        String data= theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy Fortune is: "+ data);

        System.out.println("Finished");
    }

    private void TheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\n Main Program: TheAroundAdvice");
        System.out.println("Calling getFortune");

        boolean tripWire=true;

        String data= theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy Fortune is: "+ data);

        System.out.println("Finished");
    }

    private void TheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\n Main Program: demoTheAroundAdvice");
        System.out.println("Calling getFortune");

        String data= theTrafficFortuneService.getFortune();

        System.out.println("\nMy Fortune is: "+ data);

        System.out.println("Finished");
    }

    private void TheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try{
            boolean tripWire=false;
            theAccounts=theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception e){
            System.out.println("\n\nMain Program: ... caught exception: "+e);
        }
        theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: TheAfterThrowingAdvice");
        System.out.println("--------------------------------");
        System.out.println(theAccounts);

        System.out.println("--------------------------------");
    }

    private void TheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try{
            boolean tripWire=true;
            theAccounts=theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception e){
            System.out.println("\n\nMain Program: ... caught exception: "+e);
        }
        theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: TheAfterThrowingAdvice");
        System.out.println("--------------------------------");
        System.out.println(theAccounts);

        System.out.println("--------------------------------");
    }

    private void TheAfterReturningAdvice(AccountDAO theAccountDAO) {
        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: TheAfterReturningAdvice");
        System.out.println("--------------------------------");
        System.out.println(theAccounts);

        System.out.println("--------------------------------");
    }

    private void TheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call the business method
        Account myAccount = new Account();
        myAccount.setName("Arif");
        myAccount.setLevel("Platinum");
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
