package com.devsenior.cdiaz.reservation.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.cdiaz.reservation.entity.ReservationEntity;
import com.devsenior.cdiaz.reservation.entity.ReservationStatus;

public interface ReservationRespository extends JpaRepository<ReservationEntity, Long> {

    /**
     * Checks whether a reservation exists for the given date, time and status.
     *
     * @param date   reservation date
     * @param time   reservation time
     * @param status reservation status to match
     * @return {@code true} if a matching reservation exists
     */
    boolean existsByDateAndTimeAndStatus(LocalDate date, LocalTime time, ReservationStatus status);

}
