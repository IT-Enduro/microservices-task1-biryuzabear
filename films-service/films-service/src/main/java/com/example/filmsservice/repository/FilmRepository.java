package com.example.filmsservice.repository;

import com.example.filmsservice.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Page<Film> findAll(Pageable pageable);

}