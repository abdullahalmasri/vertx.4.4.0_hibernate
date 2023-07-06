package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface BookingRepository {

  Future<List<Booking>> findAll();

 Future<Booking> findByBookingId(UUID bookingId);
  void closeFactory();
}
