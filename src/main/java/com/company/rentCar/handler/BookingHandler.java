package com.company.rentCar.handler;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.data.BookingDetails;
import com.company.rentCar.service.BookingService;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.ext.web.RoutingContext;

import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

/**
 * The type Booking handler.
 */
public class BookingHandler {


  private final BookingService service;

  /**
   * Instantiates a new Booking handler.
   *
   * @param service the service
   */
  public BookingHandler(BookingService service) {
    this.service = service;
  }

  /**
   * Read all uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<List<BookingDTO>> readAll(RoutingContext rc) {
    return service.findBookings();
  }

  /**
   * Read one uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<BookingDTO> readOne(RoutingContext rc) {
    return service.findBookingById(UUID.fromString(getId(rc)));
  }

  /**
   * Create uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Void> create(RoutingContext rc) {
    return service.saveBooking(rc.body().asJsonObject().mapTo(BookingDTO.class));
  }

  /**
   * Update uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> update(RoutingContext rc) {
    UUID bookingId = UUID.fromString(getId(rc));
    BookingDTO dto = rc.body().asJsonObject().mapTo(BookingDTO.class);
    dto.setBookingId(bookingId);
    return service.updateBooking(dto);
  }

  /**
   * Delete uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> delete(RoutingContext rc) {
    return
      service.deleteBooking(UUID.fromString(getId(rc)));
  }

  /**
   * Gets details.
   *
   * @param rc the rc
   * @return the details
   */
  public Uni<BookingDetails> getDetails(RoutingContext rc) {
    return service.findDetails(UUID.fromString(getId(rc)));
  }

  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
