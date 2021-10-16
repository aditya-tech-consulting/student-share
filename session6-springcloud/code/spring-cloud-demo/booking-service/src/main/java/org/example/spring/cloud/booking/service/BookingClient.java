package org.example.spring.cloud.booking.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("seating-server")
public interface BookingClient {
    @RequestMapping("/seats")
    String available();
}
