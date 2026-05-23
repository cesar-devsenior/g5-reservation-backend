package com.devsenior.cdiaz.reservation.exception;

/**
 * Base exception for reservation domain rule violations.
 */
public class ReservationBusinessException extends RuntimeException {

    /**
     * Creates an exception with the given message.
     *
     * @param message human-readable description of the violation
     */
    public ReservationBusinessException(String message) {
        super(message);
    }
}
