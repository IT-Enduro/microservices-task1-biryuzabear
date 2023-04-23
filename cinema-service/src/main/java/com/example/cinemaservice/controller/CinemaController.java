package com.example.cinemaservice.controller;

import com.example.cinemaservice.dto.CinemaDTO;
import com.example.cinemaservice.dto.CinemaFilmsDTO;
import com.example.cinemaservice.dto.PageDTO;
import com.example.cinemaservice.serivce.CinemaServiceBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CinemaController {
    private final CinemaServiceBean cinemaServiceBean;
    public CinemaController(CinemaServiceBean cinemaServiceBean) {
        this.cinemaServiceBean = cinemaServiceBean;
    }

    @GetMapping("/cinema")
    public ResponseEntity<PageDTO<CinemaDTO>> getAllFilms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CinemaDTO> cinemaPage = cinemaServiceBean.findAll(pageable);

        return ResponseEntity.ok().body(new PageDTO<>(cinemaPage));
    }

    @GetMapping("/cinema/{cinemaUid}/films")
    public ResponseEntity<Object> getAllFilms(@PathVariable UUID cinemaUid) {
        CinemaFilmsDTO cinemaFilms = cinemaServiceBean.getFilmSessionsByCinemaUid(cinemaUid);
        if(cinemaFilms == null){
            return new ResponseEntity<>("Не найдено", HttpStatus.NOT_FOUND);
        } else{
            return ResponseEntity.ok().body(cinemaFilms);
        }
    }


}