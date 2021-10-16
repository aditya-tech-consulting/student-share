package org.example.spring.cloud.seating.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeatingServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SeatingServerApplication.class, args);
    }
}