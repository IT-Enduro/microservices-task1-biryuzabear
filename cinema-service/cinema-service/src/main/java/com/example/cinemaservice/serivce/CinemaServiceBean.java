package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.CinemaDTO;
import com.example.cinemaservice.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceBean implements CinemaService {

    final
    CinemaRepository cinemaRepository;

    public CinemaServiceBean(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Page<CinemaDTO> findAll(Pageable pageable) {
        return cinemaRepository.findAll(pageable).map(CinemaDTO::new);
    }

}
