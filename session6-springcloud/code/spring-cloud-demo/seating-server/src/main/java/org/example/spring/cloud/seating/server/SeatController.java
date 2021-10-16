package org.example.spring.cloud.seating.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatRepository repository;

    @PostMapping("/load")
    public String loadSeats(){
        repository.save(new Seat("A",1,"Available"));
        repository.save(new Seat("A",2,"Available"));
        repository.save(new Seat("A",3,"Available"));
        repository.save(new Seat("A",4,"Available"));
        repository.save(new Seat("A",5,"Available"));
        repository.save(new Seat("A",6,"Available"));

        repository.save(new Seat("B",1,"Available"));
        repository.save(new Seat("B",2,"Available"));
        repository.save(new Seat("B",3,"Available"));
        repository.save(new Seat("B",4,"Available"));
        repository.save(new Seat("B",5,"Available"));
        repository.save(new Seat("B",6,"Available"));

        repository.save(new Seat("C",1,"Available"));
        repository.save(new Seat("C",2,"Available"));
        repository.save(new Seat("C",3,"Available"));
        repository.save(new Seat("C",4,"Available"));
        repository.save(new Seat("C",5,"Available"));
        repository.save(new Seat("C",6,"Available"));

        repository.save(new Seat("D",1,"Available"));
        repository.save(new Seat("D",2,"Available"));
        repository.save(new Seat("D",3,"Available"));
        repository.save(new Seat("D",4,"Available"));
        repository.save(new Seat("D",5,"Available"));
        repository.save(new Seat("D",6,"Available"));

        repository.save(new Seat("E",1,"Available"));
        repository.save(new Seat("E",2,"Available"));
        repository.save(new Seat("E",3,"Available"));
        repository.save(new Seat("E",4,"Available"));
        repository.save(new Seat("E",5,"Available"));
        repository.save(new Seat("E",6,"Available"));

        repository.save(new Seat("F",1,"Available"));
        repository.save(new Seat("F",2,"Available"));
        repository.save(new Seat("F",3,"Available"));
        repository.save(new Seat("F",4,"Available"));
        repository.save(new Seat("F",5,"Available"));
        repository.save(new Seat("F",6,"Available"));

        repository.save(new Seat("G",1,"Available"));
        repository.save(new Seat("G",2,"Available"));
        repository.save(new Seat("G",3,"Available"));
        repository.save(new Seat("G",4,"Available"));
        repository.save(new Seat("G",5,"Available"));
        repository.save(new Seat("G",6,"Available"));
        return "Seats Loaded";
    }
    @GetMapping
    public ResponseEntity available(){
        List<Seat> seats = repository.findByStatus("Available");
        int count = 0;
        if(!seats.isEmpty()){
            count = seats.size();
        }

        return new ResponseEntity(count, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity book(@PathVariable int seatSize){
        List<Seat> seats = repository.findByStatus("Available");
        int count = 0;
        if(!seats.isEmpty()){
            count = seats.size();
        }

        if(count <= seatSize){
            List<Seat> availablePool = new ArrayList<Seat>(seatSize);
            for(int i=0;i<seatSize;i++){
                Seat seat = seats.get(i);
                seat.setStatus("Booked");
                availablePool.add(seat);
            }
            repository.saveAll(availablePool);
            return new ResponseEntity(availablePool,HttpStatus.OK);
        }else{
            return new ResponseEntity("Seats not available", HttpStatus.EXPECTATION_FAILED);
        }
    }


}
