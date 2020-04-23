package ua.lviv.iot.seafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.seafood.dataaccess", "ua.lviv.iot.seafood.business", "ua.lviv.iot.seafood.controller" })
@EnableJpaRepositories("ua.lviv.iot.seafood.dataaccess")
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}