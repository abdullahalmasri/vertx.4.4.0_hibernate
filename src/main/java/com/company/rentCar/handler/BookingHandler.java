package com.company.rentCar.handler;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.model.Booking;
import com.company.rentCar.service.BookingService;
import com.company.rentCar.utils.ResponseUtils;
import io.vertx.core.Future;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

public class BookingHandler {


  private final BookingService service;

  public BookingHandler(BookingService service) {
    this.service = service;
  }

  public Future<List<BookingDTO>> readAll(RoutingContext rc) {
    List<BookingDTO> bookingList = new ArrayList<>();
    return service.findBookings()
      .onSuccess(success ->{
        bookingList.addAll(success);
        ResponseUtils.buildOkResponse(rc, success);
      } );
  }

  public Future<BookingDTO> readOne(RoutingContext rc) {
    return service.findBookingById(UUID.fromString(getId(rc)))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<BookingDTO> create(RoutingContext rc) {

    return service.saveBooking(rc.body().asJsonObject().mapTo(BookingDTO.class))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<BookingDTO> update(RoutingContext rc) {
    return service.updateBooking(rc.body().asJsonObject().mapTo(BookingDTO.class))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<Void> delete(RoutingContext rc) {
    return
    service.deleteBooking(UUID.fromString(getId(rc)))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
