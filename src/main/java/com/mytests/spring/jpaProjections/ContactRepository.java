package com.mytests.spring.jpaProjections;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * *
 * <p>Created by irina on 6/29/2022.</p>
 * <p>Project: spring-boot-jpa-projection</p>
 * *
 */
@RepositoryDefinition(domainClass = Contact.class, idClass = Integer.class)
public interface ContactRepository {
    List<Contact> findBy();
}
