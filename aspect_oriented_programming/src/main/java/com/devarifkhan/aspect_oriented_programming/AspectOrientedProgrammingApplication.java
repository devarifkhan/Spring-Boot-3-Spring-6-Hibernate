package com.devarifkhan.aspect_oriented_programming;

import com.devarifkhan.aspect_oriented_programming.dao.AccountDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
        return runner -> {
            TheBeforeAdvice(theAccountDAO);
        };
    }

    private void TheBeforeAdvice(AccountDAO theAccountDAO) {
        // call the business method
        theAccountDAO.addAccount();

    }
}
