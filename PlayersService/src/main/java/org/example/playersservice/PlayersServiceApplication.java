package org.example.playersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlayersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayersServiceApplication.class, args);
    }

}
