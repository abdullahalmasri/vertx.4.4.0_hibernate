package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface BookingRepository {

  Future<List<Booking>> findAll();

 Future<Booking> findByBookingId(UUID bookingId);

 Future<Booking> saveBooking(Booking booking);

 Future<Booking> updateBooking(Booking booking);

 Future<Void> deleteBookingById(UUID bookingId);

// Future<BookingDetails> findBookingDetailsById(UUID bookingId);
}
