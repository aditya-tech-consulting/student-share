package org.example.spring.cloud.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingClient bookingClient;
    @GetMapping
    public String available(){
        return bookingClient.available();
    }
}
