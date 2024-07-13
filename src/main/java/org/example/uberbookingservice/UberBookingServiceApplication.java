package org.example.uberbookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.*")
@EntityScan("org.*")
public class UberBookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberBookingServiceApplication.class, args);
    }

}
