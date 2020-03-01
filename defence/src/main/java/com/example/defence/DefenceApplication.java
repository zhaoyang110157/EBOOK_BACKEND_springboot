package com.example.defence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class DefenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefenceApplication.class, args);
    }

}
