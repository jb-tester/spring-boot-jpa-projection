package com.mytests.spring.jpaProjections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaProjectionApplication implements CommandLineRunner {

    @Autowired
    private ContactService contactService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaProjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        contactService.display();
    }
}
