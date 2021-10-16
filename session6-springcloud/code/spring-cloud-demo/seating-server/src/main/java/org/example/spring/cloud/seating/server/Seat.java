package org.example.spring.cloud.seating.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Seat {

    @Id
    @GeneratedValue
    Long id;
    String seatingRow;
    Integer number;
    String status;

    public Seat() {
    }

    public Seat(String row, Integer number, String status) {
        this.seatingRow = row;
        this.number = number;
        this.status = status;
    }

    public Seat(Long id, String row, Integer number, String status) {
        this.id = id;
        this.seatingRow = row;
        this.number = number;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatingRow() {
        return seatingRow;
    }

    public void setSeatingRow(String seatingRow) {
        this.seatingRow = seatingRow;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row='" + seatingRow + '\'' +
                ", number=" + number +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) && Objects.equals(seatingRow, seat.seatingRow) && Objects.equals(number, seat.number) && Objects.equals(status, seat.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatingRow, number, status);
    }
}
