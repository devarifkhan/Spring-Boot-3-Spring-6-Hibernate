package com.devarifkhan.jpa_one_to_one_uni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOneToOneUniApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneUniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args){
        return runner -> {
            System.out.println("Hello World");
        };
    }


}
