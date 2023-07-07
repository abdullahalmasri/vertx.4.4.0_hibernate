package com.company.rentCar.handler;

import com.company.rentCar.model.Booking;
import com.company.rentCar.sql.BookingRepository;
import com.company.rentCar.utils.ResponseUtils;
import io.vertx.core.Future;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public class BookingHandler {


  private final BookingRepository repository;

  public BookingHandler(BookingRepository repository) {
    this.repository = repository;
  }
  public Future<List<Booking>> readAll(RoutingContext rc) {
     return repository.findAll()
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc,success));
  }
}
