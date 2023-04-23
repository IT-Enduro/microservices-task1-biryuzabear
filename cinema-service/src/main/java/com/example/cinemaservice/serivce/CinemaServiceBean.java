package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.CinemaDTO;
import com.example.cinemaservice.dto.CinemaFilmsDTO;
import com.example.cinemaservice.dto.FilmDTO;
import com.example.cinemaservice.dto.PageFilmDTO;
import com.example.cinemaservice.model.Cinema;
import com.example.cinemaservice.model.FilmSession;
import com.example.cinemaservice.repository.CinemaRepository;
import com.example.cinemaservice.repository.FilmSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaServiceBean implements CinemaService {

    private final String GET_FILMS_URL;
    final
    CinemaRepository cinemaRepository;
    final
    FilmSessionRepository filmSessionRepository;
    final
    RestTemplate restTemplate;

    public CinemaServiceBean(CinemaRepository cinemaRepository,
                             FilmSessionRepository filmSessionRepository,
                             RestTemplate restTemplate,
                             @Value("${app.films.get.url}") String getFilmsUrl) {
        this.cinemaRepository = cinemaRepository;
        this.filmSessionRepository = filmSessionRepository;
        this.restTemplate = restTemplate;
        this.GET_FILMS_URL = getFilmsUrl;
    }

    @Override
    public Page<CinemaDTO> findAll(Pageable pageable) {
        return cinemaRepository.findAll(pageable).map(CinemaDTO::new);
    }

    @Override
    public CinemaFilmsDTO getFilmSessionsByCinemaUid(UUID cinemaUid) {
        Cinema cinema = cinemaRepository.findCinemaByCinemaUid(cinemaUid);
        List<FilmSession> sessions = filmSessionRepository.findFilmSessionsByCinema(cinema);
        List<FilmSession> distinctByFilms = sessions
                .stream()
                .map(FilmSession::getFilmUid)
                .distinct()
                .map(uuid -> sessions.stream()
                        .filter(session -> session.getFilmUid().equals(uuid))
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        PageFilmDTO films = restTemplate.getForObject(GET_FILMS_URL, PageFilmDTO.class);
        List<FilmDTO> filmList = films.getItems().stream()
                .filter(filmDTO -> distinctByFilms.stream()
                        .anyMatch(session -> session.getFilmUid().toString().equals(filmDTO.getFilmUid())))
                .toList();
        return new CinemaFilmsDTO(cinema, filmList);
    }
}
