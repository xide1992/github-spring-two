package com.yy.exercisespring.service.ioctest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public User getUser() {
        return new User();
    }
}
