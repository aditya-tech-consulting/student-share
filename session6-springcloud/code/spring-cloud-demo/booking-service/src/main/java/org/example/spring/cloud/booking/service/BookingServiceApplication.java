package org.example.spring.cloud.booking.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = BookingClient.class)
public class BookingServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
}