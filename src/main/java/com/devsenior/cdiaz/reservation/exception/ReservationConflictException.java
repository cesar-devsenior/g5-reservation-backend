package com.devsenior.cdiaz.reservation.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when a reservation cannot be created because the date and time slot is already taken.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ReservationConflictException extends ReservationBusinessException {

    /**
     * Creates an exception for an occupied slot.
     *
     * @param date reservation date
     * @param time reservation time
     */
    public ReservationConflictException(LocalDate date, LocalTime time) {
        super("A reservation already exists for date %s and time %s".formatted(date, time));
    }
}
