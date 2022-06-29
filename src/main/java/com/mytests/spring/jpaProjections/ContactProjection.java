package com.mytests.spring.jpaProjections;

import org.springframework.beans.factory.annotation.Value;

/**
 * *
 * <p>Created by irina on 6/29/2022.</p>
 * <p>Project: spring-boot-jpa-projection</p>
 * *
 */
public interface ContactProjection {

    @Value("#{#target.firstname+' '+#target.lastname}")
    String getName();
    @Value("#{#target.email}")
    String getMailAddress();

    //String getPhone();
}
