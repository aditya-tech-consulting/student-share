package org.example.spring.cloud.booking.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //Ribbon
public class BookingServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
}