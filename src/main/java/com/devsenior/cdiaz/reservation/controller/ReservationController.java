package com.devsenior.cdiaz.reservation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.cdiaz.reservation.dto.CreateReservationRequest;
import com.devsenior.cdiaz.reservation.dto.ReservationResponse;
import com.devsenior.cdiaz.reservation.service.ReservationService;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReservationResponse createReservation(@RequestBody CreateReservationRequest request) {
        return reservationService.createReservation(request);
    }

    @DeleteMapping("/{id}")
    public ReservationResponse cancelReservation(@PathVariable("id") Long id) {
        return reservationService.cancelReservation(id);
    }

    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
