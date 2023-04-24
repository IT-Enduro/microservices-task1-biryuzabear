package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.IsPossibleToBuyRequestRequest;
import com.example.cinemaservice.model.FilmSession;
import com.example.cinemaservice.repository.CinemaRepository;
import com.example.cinemaservice.repository.FilmSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;

@Service
public class FilmSessionServiceBean implements FilmSessionService {
    final RestTemplate restTemplate;
    final FilmSessionRepository filmSessionRepository;
    final CinemaRepository cinemaRepository;

    @Override
    public boolean isPossibleToBuyTicket(IsPossibleToBuyRequestRequest isPossibleToBuyRequestRequest) {
        FilmSession filmSession = getFilmSession(isPossibleToBuyRequestRequest);
        if (filmSession == null || filmSession.getBookedSeats() >= filmSession.getTotalSeats()) {
            return false;
        }
        filmSession.setBookedSeats(filmSession.getBookedSeats() + 1);
        filmSessionRepository.save(filmSession);
        return true;
    }

    private FilmSession getFilmSession(IsPossibleToBuyRequestRequest isPossibleToBuyRequestRequest) {
        FilmSession filmSession = filmSessionRepository.findFilmSessionsByCinemaAndFilmUidAndDateAnd(cinemaRepository.findCinemaByCinemaUid(isPossibleToBuyRequestRequest.getCinemaUid()),
                isPossibleToBuyRequestRequest.getFilmUid(),
                Timestamp.valueOf(isPossibleToBuyRequestRequest.getDate()));
        return filmSession;
    }

    public FilmSessionServiceBean(FilmSessionRepository filmSessionRepository, RestTemplate restTemplate, CinemaRepository cinemaRepository) {
        this.filmSessionRepository = filmSessionRepository;
        this.restTemplate = restTemplate;
        this.cinemaRepository = cinemaRepository;
    }
}
