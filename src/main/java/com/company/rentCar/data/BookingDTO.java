package com.company.rentCar.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Booking dto.
 */
public class BookingDTO implements Serializable {

  private static final long serialVersionUID = 5L;

  private UUID bookingId;

  private UUID bookingCarId;

  private UUID bookingCustomerId;

  private Date bookingStart;

  private Date bookingEnd;

  /**
   * Instantiates a new Booking dto.
   *
   * @param bookingId         the booking id
   * @param bookingCarId      the booking car id
   * @param bookingCustomerId the booking customer id
   * @param bookingStart      the booking start
   * @param bookingEnd        the booking end
   */
  public BookingDTO(UUID bookingId, UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingId = bookingId;
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  /**
   * Instantiates a new Booking dto.
   *
   * @param bookingCarId      the booking car id
   * @param bookingCustomerId the booking customer id
   * @param bookingStart      the booking start
   * @param bookingEnd        the booking end
   */
  public BookingDTO(UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd) {
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  /**
   * Instantiates a new Booking dto.
   */
  public BookingDTO() {
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
