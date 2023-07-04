package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;

import java.util.List;

public interface BookingRepository {

  Future<List<Booking>> findAll();
}
