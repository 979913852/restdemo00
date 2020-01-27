package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Restdemo001Application {

    public static void main(String[] args) {
        SpringApplication.run(Restdemo001Application.class, args);
    }

}
