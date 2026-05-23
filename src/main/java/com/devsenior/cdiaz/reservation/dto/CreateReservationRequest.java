package com.devsenior.cdiaz.reservation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Input data required to create a new reservation.
 *
 * @param customerName name of the customer making the reservation
 * @param date         reservation date
 * @param time         reservation time
 * @param service      requested service description
 */
public record CreateReservationRequest(
        String customerName,
        LocalDate date,
        LocalTime time,
        String service
) {
}
