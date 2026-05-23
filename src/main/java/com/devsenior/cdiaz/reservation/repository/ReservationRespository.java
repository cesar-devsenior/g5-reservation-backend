package com.devsenior.cdiaz.reservation.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.cdiaz.reservation.entity.ReservationEntity;

public interface ReservationRespository extends JpaRepository<ReservationEntity, Long> {

    // método que permita verificar si ya existe una reserva para una fecha y una hora específicas.
    boolean existsByDateAndTime(LocalDate date, LocalTime time);

}
