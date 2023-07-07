package com.company.rentCar.service;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.data.BookingDetails;
import com.company.rentCar.model.Booking;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface BookingService {


  Future<List<BookingDTO>> findBookings();

  Future<BookingDTO> findBookingById(UUID bookId);

  Future<BookingDTO> saveBooking(BookingDTO booking);

  Future<BookingDTO> updateBooking(BookingDTO booking);

  Future<Void> deleteBooking(UUID bookId);

  Future<BookingDetails> findDetails(UUID bookId);

}
