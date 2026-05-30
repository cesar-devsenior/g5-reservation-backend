package com.devsenior.cdiaz.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when a reservation with the given identifier does not exist.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReservationNotFoundException extends ReservationBusinessException {

    /**
     * Creates an exception for a missing reservation.
     *
     * @param id reservation identifier
     */
    public ReservationNotFoundException(Long id) {
        super("Reservation not found with id: %d".formatted(id));
    }
}
