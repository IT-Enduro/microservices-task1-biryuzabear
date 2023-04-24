package com.example.cinemaservice.controller;

import com.example.cinemaservice.dto.IsPossibleToBuyRequestRequest;
import com.example.cinemaservice.serivce.FilmSessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FilmSessionController {
    final
    FilmSessionService filmSessionService;

    public FilmSessionController(FilmSessionService filmSessionService) {
        this.filmSessionService = filmSessionService;
    }

    @PostMapping("/session/is-possible-to-buy")
    @ResponseBody
    public boolean isPossibleToBuyTicket(@RequestBody IsPossibleToBuyRequestRequest isPossibleToBuyRequestRequest) {
      return filmSessionService.isPossibleToBuyTicket(isPossibleToBuyRequestRequest);
    }

}
