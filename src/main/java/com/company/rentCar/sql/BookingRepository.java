package com.company.rentCar.sql;

import com.company.rentCar.data.BookingDetails;
import com.company.rentCar.model.Booking;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

/**
 * The interface Booking repository.
 */
public interface BookingRepository {

  /**
   * Find all uni.
   *
   * @return the uni
   */
  Uni<List<Booking>> findAll();

  /**
   * Find by booking id uni.
   *
   * @param bookingId the booking id
   * @return the uni
   */
  Uni<Booking> findByBookingId(UUID bookingId);

  /**
   * Save booking uni.
   *
   * @param booking the booking
   * @return the uni
   */
  Uni<Void> saveBooking(Booking booking);

  /**
   * Update booking uni.
   *
   * @param booking the booking
   * @return the uni
   */
  Uni<Integer> updateBooking(Booking booking);

  /**
   * Delete booking by id uni.
   *
   * @param bookingId the booking id
   * @return the uni
   */
  Uni<Integer> deleteBookingById(UUID bookingId);

  /**
   * Find booking details by id uni.
   *
   * @param bookingId the booking id
   * @return the uni
   */
  Uni<BookingDetails> findBookingDetailsById(UUID bookingId);
}

