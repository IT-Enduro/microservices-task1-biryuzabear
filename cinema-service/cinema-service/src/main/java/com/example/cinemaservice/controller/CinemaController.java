package com.example.cinemaservice.controller;

import com.example.cinemaservice.dto.CinemaDTO;
import com.example.cinemaservice.dto.FilmDTO;
import com.example.cinemaservice.dto.PageDTO;
import com.example.cinemaservice.serivce.CinemaServiceBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}