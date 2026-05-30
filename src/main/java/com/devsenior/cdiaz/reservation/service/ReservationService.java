package com.devsenior.cdiaz.reservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsenior.cdiaz.reservation.dto.CreateReservationRequest;
import com.devsenior.cdiaz.reservation.dto.ReservationResponse;
import com.devsenior.cdiaz.reservation.entity.ReservationStatus;
import com.devsenior.cdiaz.reservation.exception.ReservationAlreadyCancelledException;
import com.devsenior.cdiaz.reservation.exception.ReservationConflictException;
import com.devsenior.cdiaz.reservation.exception.ReservationNotFoundException;
import com.devsenior.cdiaz.reservation.mapper.ReservationMapper;
import com.devsenior.cdiaz.reservation.repository.ReservationRespository;

/**
 * Application service for reservation business operations.
 */
@Service
public class ReservationService {

    private final ReservationRespository reservationRepository;
    private final ReservationMapper reservationMapper;

    /**
     * Creates the service with required dependencies.
     *
     * @param reservationRepository data access for reservations
     * @param reservationMapper     entity and DTO mapper
     */
    public ReservationService(
            ReservationRespository reservationRepository,
            ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Creates a reservation when no other active reservation exists for the same date and time.
     *
     * @param request reservation data to create
     * @return the created reservation representation
     * @throws ReservationConflictException if an active reservation already occupies the slot
     */
    @Transactional
    public ReservationResponse createReservation(CreateReservationRequest request) {
        if (reservationRepository.existsByDateAndTimeAndStatus(
                request.date(), request.time(), ReservationStatus.ACTIVE)) {
            throw new ReservationConflictException(request.date(), request.time());
        }

        var entity = reservationMapper.toEntity(request);
        var saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

    /**
     * Cancels an existing reservation by its identifier.
     *
     * @param id reservation identifier
     * @return the cancelled reservation representation
     * @throws ReservationNotFoundException         if no reservation exists with the given id
     * @throws ReservationAlreadyCancelledException if the reservation is already cancelled
     */
    @Transactional
    public ReservationResponse cancelReservation(Long id) {
        var entity = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        if (entity.getStatus() == ReservationStatus.CANCELLED) {
            throw new ReservationAlreadyCancelledException(id);
        }

        entity.setStatus(ReservationStatus.CANCELLED);
        var saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toResponse)
                .toList();
    }
}
