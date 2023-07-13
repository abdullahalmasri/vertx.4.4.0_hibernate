package com.company.rentCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Booking.
 */
@Entity
@Table(name = "booking_tb")
public class Booking implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "booking_id", nullable = false)
  private UUID bookingId;

  @Column(name = "booking_car_id", nullable = false)
  private UUID bookingCarId;

  @Column(name = "booking_customer_id", nullable = false)
  private UUID bookingCustomerId;

  @Column(name = "booking_start_rent_date", nullable = false)
  private Date bookingStart;

  @Column(name = "booking_end_date", nullable = false)
  private Date bookingEnd;

  /**
   * Instantiates a new Booking.
   */
  public Booking() {
  }

  /**
   * Instantiates a new Booking.
   *
   * @param bookingId         the booking id
   * @param bookingCarId      the booking car id
   * @param bookingCustomerId the booking customer id
   * @param bookingStart      the booking start
   * @param bookingEnd        the booking end
   */
  public Booking(UUID bookingId, UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingId = bookingId;
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  /**
   * Instantiates a new Booking.
   *
   * @param bookingCarId      the booking car id
   * @param bookingCustomerId the booking customer id
   * @param bookingStart      the booking start
   * @param bookingEnd        the booking end
   */
  public Booking(UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  /**
   * Gets booking id.
   *
   * @return the booking id
   */
  public UUID getBookingId() {
    return bookingId;
  }

  /**
   * Sets booking id.
   *
   * @param bookingId the booking id
   */
  public void setBookingId(UUID bookingId) {
    this.bookingId = bookingId;
  }

  /**
   * Gets booking car id.
   *
   * @return the booking car id
   */
  public UUID getBookingCarId() {
    return bookingCarId;
  }

  /**
   * Sets booking car id.
   *
   * @param bookingCarId the booking car id
   */
  public void setBookingCarId(UUID bookingCarId) {
    this.bookingCarId = bookingCarId;
  }

  /**
   * Gets booking customer id.
   *
   * @return the booking customer id
   */
  public UUID getBookingCustomerId() {
    return bookingCustomerId;
  }

  /**
   * Sets booking customer id.
   *
   * @param bookingCustomerId the booking customer id
   */
  public void setBookingCustomerId(UUID bookingCustomerId) {
    this.bookingCustomerId = bookingCustomerId;
  }

  /**
   * Gets booking start.
   *
   * @return the booking start
   */
  public Date getBookingStart() {
    return bookingStart;
  }

  /**
   * Sets booking start.
   *
   * @param bookingStart the booking start
   */
  public void setBookingStart(Date bookingStart) {
    this.bookingStart = bookingStart;
  }

  /**
   * Gets booking end.
   *
   * @return the booking end
   */
  public Date getBookingEnd() {
    return bookingEnd;
  }

  /**
   * Sets booking end.
   *
   * @param bookingEnd the booking end
   */
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
