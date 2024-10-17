package com.example.testchain.chain;

import com.example.testchain.others.Dummy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {
    @Bean
    public GodValidator getValidator() {
        GodValidator validator = new GodValidator() {};

        validator.subscribe(new ElementaryValidator<String>() {
            @Override
            public void returnNullOrThrowException(String elem) {
                throw new IllegalArgumentException("OH NO THIS IS STRING");
            }
        });

        validator.subscribe(new ElementaryValidator<Integer>() {
            @Override
            public void returnNullOrThrowException(Integer elem) {
                throw new IllegalArgumentException("OH NO THIS IS INTEGER");
            }
        });

        validator.subscribe(new ElementaryValidator<Dummy>() {
            @Override
            public void returnNullOrThrowException(Dummy elem) {
                throw new IllegalArgumentException("OH NO THIS IS DUMMY");
            }
        });

        return validator.immutable();
    }
}
