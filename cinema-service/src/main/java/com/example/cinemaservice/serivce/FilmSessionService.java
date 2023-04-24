package com.example.cinemaservice.serivce;

import com.example.cinemaservice.dto.IsPossibleToBuyRequestRequest;

public interface FilmSessionService {
    boolean isPossibleToBuyTicket(IsPossibleToBuyRequestRequest isPossibleToBuyRequestRequest);
}
