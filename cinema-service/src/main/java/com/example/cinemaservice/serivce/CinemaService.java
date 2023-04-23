package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.CinemaDTO;
import com.example.cinemaservice.dto.CinemaFilmsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CinemaService {
    Page<CinemaDTO> findAll(Pageable pageable);

    CinemaFilmsDTO getFilmSessionsByCinemaUid(UUID cinemaUid);
}
