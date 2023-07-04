package com.company.rentCar.data;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class BookingDTO {

  private UUID bookingId;

  private UUID bookingCarId;

  private UUID bookingCustomerId;

  private Date bookingStart;

  private Date bookingEnd;

  public BookingDTO(UUID bookingId, UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingId = bookingId;
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  public BookingDTO(UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  public BookingDTO() {
  }

  public UUID getBookingId() {
    return bookingId;
  }

  public void setBookingId(UUID bookingId) {
    this.bookingId = bookingId;
  }

  public UUID getBookingCarId() {
    return bookingCarId;
  }

  public void setBookingCarId(UUID bookingCarId) {
    this.bookingCarId = bookingCarId;
  }

  public UUID getBookingCustomerId() {
    return bookingCustomerId;
  }

  public void setBookingCustomerId(UUID bookingCustomerId) {
    this.bookingCustomerId = bookingCustomerId;
  }

  public Date getBookingStart() {
    return bookingStart;
  }

  public void setBookingStart(Date bookingStart) {
    this.bookingStart = bookingStart;
  }

  public Date getBookingEnd() {
    return bookingEnd;
  }

  public void setBookingEnd(Date bookingEnd) {
    this.bookingEnd = bookingEnd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BookingDTO)) return false;
    BookingDTO that = (BookingDTO) o;
    return getBookingId().equals(that.getBookingId()) && getBookingCarId().equals(that.getBookingCarId()) && getBookingCustomerId().equals(that.getBookingCustomerId()) && getBookingStart().equals(that.getBookingStart()) && getBookingEnd().equals(that.getBookingEnd());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBookingId(), getBookingCarId(), getBookingCustomerId(), getBookingStart(), getBookingEnd());
  }

  @Override
  public String toString() {
    return "BookingDTO{" +
      "bookingId=" + bookingId +
      ", bookingCarId=" + bookingCarId +
      ", bookingCustomerId=" + bookingCustomerId +
      ", bookingStart=" + bookingStart +
      ", bookingEnd=" + bookingEnd +
      '}';
  }
}
