package com.example.filmsservice.service;

import com.example.filmsservice.dto.FilmDTO;
import com.example.filmsservice.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceBean implements FilmService {

    final
    FilmRepository filmRepository;

    public FilmServiceBean(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Page<FilmDTO> findAll(Pageable pageable) {
        return filmRepository.findAll(pageable).map(FilmDTO::new);
    }

}
