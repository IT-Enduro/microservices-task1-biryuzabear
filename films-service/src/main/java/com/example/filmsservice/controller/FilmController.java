package com.example.filmsservice.controller;

import com.example.filmsservice.dto.FilmDTO;
import com.example.filmsservice.dto.PageDTO;
import com.example.filmsservice.service.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FilmController {
    private final FilmService filmService;
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public ResponseEntity<PageDTO<FilmDTO>> getAllFilms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<FilmDTO> filmPage = filmService.findAll(pageable);

        return ResponseEntity.ok().body(new PageDTO<>(filmPage));
    }


}

