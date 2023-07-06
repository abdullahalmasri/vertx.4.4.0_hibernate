package com.company.rentCar.service;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.model.Booking;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface BookingService {


  Future<List<BookingDTO>> findBookings();

  Future<Booking> findBookingById(UUID bookId);

  Future<BookingDTO> saveBooking(Booking booking);

  Future<BookingDTO> updateBooking(Booking booking);

  Future<Void> deleteBooking(UUID bookId);

}
