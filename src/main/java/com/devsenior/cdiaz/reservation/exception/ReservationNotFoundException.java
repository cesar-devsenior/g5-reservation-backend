package com.devsenior.cdiaz.reservation.exception;

/**
 * Thrown when a reservation with the given identifier does not exist.
 */
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
