package com.devsenior.cdiaz.reservation.mapper;

import org.springframework.stereotype.Component;

import com.devsenior.cdiaz.reservation.dto.CreateReservationRequest;
import com.devsenior.cdiaz.reservation.dto.ReservationResponse;
import com.devsenior.cdiaz.reservation.entity.ReservationEntity;
import com.devsenior.cdiaz.reservation.entity.ReservationStatus;

/**
 * Maps between reservation entities and API DTOs.
 */
@Component
public class ReservationMapper {

    /**
     * Builds a new active reservation entity from a create request.
     *
     * @param request validated reservation input
     * @return a transient entity ready to persist
     */
    public ReservationEntity toEntity(CreateReservationRequest request) {
        var entity = new ReservationEntity();
        entity.setCustomerName(request.customerName());
        entity.setDate(request.date());
        entity.setTime(request.time());
        entity.setService(request.service());
        entity.setStatus(ReservationStatus.ACTIVE);
        return entity;
    }

    /**
     * Converts a persisted entity to an API response.
     *
     * @param entity persisted reservation
     * @return response DTO
     */
    public ReservationResponse toResponse(ReservationEntity entity) {
        return new ReservationResponse(
                entity.getId(),
                entity.getCustomerName(),
                entity.getDate(),
                entity.getTime(),
                entity.getService(),
                entity.getStatus());
    }
}
