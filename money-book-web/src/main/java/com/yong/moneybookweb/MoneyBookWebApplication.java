package com.yong.moneybookweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class MoneyBookWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyBookWebApplication.class, args);
    }

}
