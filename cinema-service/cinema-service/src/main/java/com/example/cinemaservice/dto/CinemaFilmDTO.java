package com.example.cinemaservice.dto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CinemaFilmDTO {
    private UUID cinemaUid;
    private String name;
    private String address;
    private List<FilmDTO> films;


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

    public List<FilmDTO> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDTO> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaFilmDTO that = (CinemaFilmDTO) o;
        return Objects.equals(cinemaUid, that.cinemaUid) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaUid, name, address, films);
    }
}
