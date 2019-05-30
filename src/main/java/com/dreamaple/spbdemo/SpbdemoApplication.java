package com.dreamaple.spbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbdemoApplication.class, args);
    }

}
