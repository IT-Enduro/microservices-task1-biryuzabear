package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.CinemaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaService {
    Page<CinemaDTO> findAll(Pageable pageable);
}
