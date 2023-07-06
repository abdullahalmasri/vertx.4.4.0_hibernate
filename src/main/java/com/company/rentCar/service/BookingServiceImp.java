package com.company.rentCar.service;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.mapper.BookingMapper;
import com.company.rentCar.model.Booking;
import com.company.rentCar.sql.BookingRepository;
import io.vertx.core.Future;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingServiceImp  implements BookingService {

  private final BookingRepository repository;
  private BookingMapper mapper;

  public BookingServiceImp(BookingRepository repository) {
    this.repository = repository;
  }

  @Override
  public Future<List<BookingDTO>> findBookings() {
    List<BookingDTO> dtos = new ArrayList<>();
    repository.findAll().result().forEach(
      booking ->
        dtos.add(Mappers.getMapper(BookingMapper.class).bookingToBookingDTO(booking))
    );
    return Future.succeededFuture(dtos);
  }

  @Override
  public Future<BookingDTO> findBookingById(UUID bookId) {
    BookingDTO dto = Mappers.getMapper(BookingMapper.class)
      .bookingToBookingDTO(repository.findByBookingId(bookId).result());

    return Future.succeededFuture(dto);
  }

  @Override
  public Future<BookingDTO> saveBooking(BookingDTO booking) {
      if(booking.getBookingId()==null) {
        booking.setBookingId(UUID.randomUUID());
      }
     repository.saveBooking(Mappers.getMapper(BookingMapper.class).bookingDTOToBooking(booking))
      .result();
    return Future.succeededFuture(booking);
  }

  @Override
  public Future<BookingDTO> updateBooking(BookingDTO booking) {
    return null;
  }

  @Override
  public Future<Void> deleteBooking(UUID bookId) {
    return null;
  }
}
