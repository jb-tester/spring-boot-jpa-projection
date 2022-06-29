package com.mytests.spring.jpaProjections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 6/29/2022.</p>
 * <p>Project: spring-boot-jpa-projection</p>
 * *
 */
@Service
public class ContactService {

    @Autowired
    private ContactProjectionRepository contactProjectionRepository;
    @Autowired
    private ContactRepository contactRepository;

    public void display(){
        System.out.println("-- find all: --");
        for (Contact contact : contactRepository.findBy()) {
            System.out.println(contact.getFirstname() + " " + contact.getLastname());
        }
        System.out.println("-- find all projections: --");
        for (ContactProjection contact : contactProjectionRepository.findBy()) {
            System.out.println(contact.getName() + " " + contact.getMailAddress());
        }
        System.out.println("-- find projections by name: --");
        for (ContactProjection contact : contactProjectionRepository.findByFirstname("irina")) {
            System.out.println(contact.getName() + " " + contact.getMailAddress());
        }
    }
}
