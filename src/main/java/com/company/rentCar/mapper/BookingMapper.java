package com.company.rentCar.mapper;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Booking mapper.
 */
@Mapper
public interface BookingMapper {
  /**
   * Booking to booking dto booking dto.
   *
   * @param entity the entity
   * @return the booking dto
   */
  @Mapping(target = "bookingId", source = "entity.bookingId")
  @Mapping(target = "bookingCarId", source = "entity.bookingCarId")
  @Mapping(target = "bookingCustomerId", source = "entity.bookingCustomerId")
  @Mapping(target = "bookingStart", source = "entity.bookingStart")
  @Mapping(target = "bookingEnd", source = "entity.bookingEnd")
  BookingDTO bookingToBookingDTO(Booking entity);


  /**
   * Booking dto to booking booking.
   *
   * @param dto the dto
   * @return the booking
   */
  @Mapping(target = "bookingId", source = "dto.bookingId")
  @Mapping(target = "bookingCarId", source = "dto.bookingCarId")
  @Mapping(target = "bookingCustomerId", source = "dto.bookingCustomerId")
  @Mapping(target = "bookingStart", source = "dto.bookingStart")
  @Mapping(target = "bookingEnd", source = "dto.bookingEnd")
  Booking bookingDTOToBooking(BookingDTO dto);
}
