package com.company.rentCar.service;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.data.BookingDetails;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

/**
 * The interface Booking service.
 */
public interface BookingService {


  /**
   * Find bookings uni.
   *
   * @return the uni
   */
  Uni<List<BookingDTO>> findBookings();

  /**
   * Find booking by id uni.
   *
   * @param bookId the book id
   * @return the uni
   */
  Uni<BookingDTO> findBookingById(UUID bookId);

  /**
   * Save booking uni.
   *
   * @param booking the booking
   * @return the uni
   */
  Uni<Void> saveBooking(BookingDTO booking);

  /**
   * Update booking uni.
   *
   * @param booking the booking
   * @return the uni
   */
  Uni<Integer>updateBooking(BookingDTO booking);

  /**
   * Delete booking uni.
   *
   * @param bookId the book id
   * @return the uni
   */
  Uni<Integer> deleteBooking(UUID bookId);

  /**
   * Find details uni.
   *
   * @param bookId the book id
   * @return the uni
   */
  Uni<BookingDetails> findDetails(UUID bookId);

}
