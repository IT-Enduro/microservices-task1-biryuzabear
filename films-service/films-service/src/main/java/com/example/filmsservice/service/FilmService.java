package com.example.filmsservice.service;

import com.example.filmsservice.dto.FilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmService {
    Page<FilmDTO> findAll(Pageable pageable);
}
