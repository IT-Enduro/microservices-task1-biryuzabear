package com.example.cinemaservice.dto;

import com.example.cinemaservice.model.Cinema;

import java.util.Objects;
import java.util.UUID;

public class CinemaDTO {
    private UUID cinemaUid;
    private String name;
    private String address;

    public CinemaDTO() {
    }

    public CinemaDTO(Cinema cinema) {
        this.cinemaUid = cinema.getCinemaUid();
        this.address = cinema.getAddress();
        this.name = cinema.getName();
    }

    public UUID getCinemaUid() {
        return cinemaUid;
    }

    public void setCinemaUid(UUID cinemaUid) {
        this.cinemaUid = cinemaUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaDTO cinemaDTO = (CinemaDTO) o;
        return Objects.equals(cinemaUid, cinemaDTO.cinemaUid) && Objects.equals(name, cinemaDTO.name) && Objects.equals(address, cinemaDTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaUid, name, address);
    }
}
