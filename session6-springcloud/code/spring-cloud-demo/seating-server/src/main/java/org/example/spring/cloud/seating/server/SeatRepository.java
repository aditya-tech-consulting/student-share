package org.example.spring.cloud.seating.server;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    List<Seat> findByStatus(String status);
}
