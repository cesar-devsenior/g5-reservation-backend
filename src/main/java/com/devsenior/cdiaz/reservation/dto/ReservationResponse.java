package com.devsenior.cdiaz.reservation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.devsenior.cdiaz.reservation.entity.ReservationStatus;

/**
 * API representation of a reservation.
 *
 * @param id           unique identifier
 * @param customerName customer name
 * @param date         reservation date
 * @param time         reservation time
 * @param service      requested service
 * @param status       current reservation status
 */
public record ReservationResponse(
        Long id,
        String customerName,
        LocalDate date,
        LocalTime time,
        String service,
        ReservationStatus status
) {
}
