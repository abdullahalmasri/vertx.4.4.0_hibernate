package com.company.rentCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "booking_tb")
public class Booking {

  @Id
  @Column(name = "booking_id", nullable = false)
  private UUID bookingId;

  @Column(name = "booking_car_id",nullable = false)
  private UUID bookingCarId;

  @Column(name = "booking_customer_id",nullable = false)
  private UUID bookingCustomerId;

  @Column(name = "booking_start_rent_date",nullable = false)
  private Date bookingStart;

  @Column(name = "booking_end_date",nullable = false)
  private Date bookingEnd;

  public Booking() {
  }

  public Booking(UUID bookingId, UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingId = bookingId;
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  public Booking(UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
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
    if (!(o instanceof Booking)) return false;
    Booking booking = (Booking) o;
    return getBookingId().equals(booking.getBookingId()) && getBookingCarId().equals(booking.getBookingCarId()) && getBookingCustomerId().equals(booking.getBookingCustomerId()) && getBookingStart().equals(booking.getBookingStart()) && getBookingEnd().equals(booking.getBookingEnd());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBookingId(), getBookingCarId(), getBookingCustomerId(), getBookingStart(), getBookingEnd());
  }

  @Override
  public String toString() {
    return "Booking{" +
      "bookingId=" + bookingId +
      ", bookingCarId=" + bookingCarId +
      ", bookingCustomerId=" + bookingCustomerId +
      ", bookingStart=" + bookingStart +
      ", bookingEnd=" + bookingEnd +
      '}';
  }
}
