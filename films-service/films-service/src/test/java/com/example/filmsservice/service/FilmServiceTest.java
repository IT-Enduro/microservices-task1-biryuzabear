package com.example.filmsservice.service;

import com.example.filmsservice.dto.FilmDTO;
import com.example.filmsservice.model.Film;
import com.example.filmsservice.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilmServiceTest {

    @Test
    void findAll() {
        Film film1 = new Film();
        film1.setId(1);
        film1.setFilmUid(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"));
        film1.setName("The Shawshank Redemption");
        film1.setRating(9.3);
        film1.setDirector("Frank Darabont");
        film1.setProducer("Niki Marvin");
        film1.setGenre("Drama");

        Film film2 = new Film();
        film2.setId(2);
        film2.setFilmUid(UUID.fromString("223e4567-e89b-12d3-a456-426655440000"));
        film2.setName("The Godfather");
        film2.setRating(9.2);
        film2.setDirector("Francis Ford Coppola");
        film2.setProducer("Albert S. Ruddy");
        film2.setGenre("Crime, Drama");

        FilmDTO filmDTO1 = new FilmDTO();
        filmDTO1.setFilmUid("123e4567-e89b-12d3-a456-426655440000");
        filmDTO1.setName("The Shawshank Redemption");
        filmDTO1.setRating(9.3);
        filmDTO1.setDirector("Frank Darabont");
        filmDTO1.setProducer("Niki Marvin");
        filmDTO1.setGenre("Drama");

        FilmDTO filmDTO2 = new FilmDTO();
        filmDTO2.setFilmUid("223e4567-e89b-12d3-a456-426655440000");
        filmDTO2.setName("The Godfather");
        filmDTO2.setRating(9.2);
        filmDTO2.setDirector("Francis Ford Coppola");
        filmDTO2.setProducer("Albert S. Ruddy");
        filmDTO2.setGenre("Crime, Drama");

        List<FilmDTO> filmDTOList = new ArrayList<>();
        filmDTOList.add(filmDTO1);
        filmDTOList.add(filmDTO2);

        PageRequest pageRequest = PageRequest.of(1, 10);

        Page<FilmDTO> pageDTO = new PageImpl<>(filmDTOList, pageRequest, filmDTOList.size());

        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        filmList.add(film2);

        Page<Film> page = new PageImpl<>(filmList, pageRequest, filmList.size());

        Pageable pageable = PageRequest.of(1, 10);

        FilmRepository filmRepositoryMock = mock(FilmRepository.class);
        FilmService filmService = new FilmServiceBean(filmRepositoryMock);

        when(filmRepositoryMock.findAll(pageable)).thenReturn(page);

        assertIterableEquals(pageDTO.getContent(), filmService.findAll(pageable).getContent());
    }
}