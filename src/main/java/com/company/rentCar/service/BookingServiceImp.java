package com.company.rentCar.service;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.data.BookingDetails;
import com.company.rentCar.mapper.BookingMapper;
import com.company.rentCar.sql.BookingRepository;
import io.smallrye.mutiny.Uni;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Booking service imp.
 */
public class BookingServiceImp implements BookingService, Serializable {
  private static final long serialVersionUID = 90L;

  private final BookingRepository repository;

  /**
   * Instantiates a new Booking service imp.
   *
   * @param repository the repository
   */
  public BookingServiceImp(BookingRepository repository) {
    this.repository = repository;
  }

  @Override
  public Uni<List<BookingDTO>> findBookings() {

    Uni<List<BookingDTO>> dtos = repository.findAll()
      .onItem()
      .transform(bookings -> bookings
        .stream()
        .map(booking ->
          Mappers.getMapper(BookingMapper.class).bookingToBookingDTO(booking)
        )
        .collect(Collectors.toList())
      );


    return dtos;
  }

  @Override
  public Uni<BookingDTO> findBookingById(UUID bookId) {
    Uni<BookingDTO> dto =
      repository.findByBookingId(bookId)
        .onItem()
        .ifNotNull()
        .transform(booking ->
          Mappers.getMapper(BookingMapper.class).bookingToBookingDTO(booking)
        );
    return dto;

  }

  @Override
  public Uni<Void> saveBooking(BookingDTO booking) {
    if (booking.getBookingId() == null) {
      booking.setBookingId(UUID.randomUUID());
    }
    return repository.saveBooking(Mappers.getMapper(BookingMapper.class).bookingDTOToBooking(booking));

  }

  @Override
  public Uni<Integer> updateBooking(BookingDTO booking) {
    if (booking.getBookingId() == null) {
      return null;
    }
    Uni<Integer> success = repository.updateBooking(Mappers.getMapper(BookingMapper.class).bookingDTOToBooking(booking));
    return success;
  }

  @Override
  public Uni<Integer> deleteBooking(UUID bookId) {
    return repository.deleteBookingById(bookId);

  }

  @Override
  public Uni<BookingDetails> findDetails(UUID bookId) {
    Uni<BookingDetails> bookingDetails = repository.findBookingDetailsById(bookId);
    return bookingDetails;
  }
}
