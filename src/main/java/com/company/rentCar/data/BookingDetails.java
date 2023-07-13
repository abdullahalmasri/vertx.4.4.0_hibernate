package com.company.rentCar.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Booking details.
 */
public class BookingDetails implements Serializable {

  private static final long serialVersionUID = 7L;

  private UUID bookingId;

  private UUID bookingCarId;

  private UUID bookingCustomerId;

  private Date bookingStart;

  private Date bookingEnd;

  private String carModel;

  private BigDecimal pricePerDay;

  private String carType;

  private Boolean carAvailability;

  private String customerName;

  private String customerEmail;

  private String customerPhone;

  private Boolean customerDriverLicense;

  private Date customerBirth;

  /**
   * Instantiates a new Booking details.
   */
  public BookingDetails() {
  }

  /**
   * Instantiates a new Booking details.
   *
   * @param bookingId             the booking id
   * @param bookingCarId          the booking car id
   * @param bookingCustomerId     the booking customer id
   * @param bookingStart          the booking start
   * @param bookingEnd            the booking end
   * @param carModel              the car model
   * @param pricePerDay           the price per day
   * @param carType               the car type
   * @param carAvailability       the car availability
   * @param customerName          the customer name
   * @param customerEmail         the customer email
   * @param customerPhone         the customer phone
   * @param customerDriverLicense the customer driver license
   * @param customerBirth         the customer birth
   */
  public BookingDetails(UUID bookingId, UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.bookingId = bookingId;
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }

  /**
   * Instantiates a new Booking details.
   *
   * @param bookingCarId          the booking car id
   * @param bookingCustomerId     the booking customer id
   * @param bookingStart          the booking start
   * @param bookingEnd            the booking end
   * @param carModel              the car model
   * @param pricePerDay           the price per day
   * @param carType               the car type
   * @param carAvailability       the car availability
   * @param customerName          the customer name
   * @param customerEmail         the customer email
   * @param customerPhone         the customer phone
   * @param customerDriverLicense the customer driver license
   * @param customerBirth         the customer birth
   */
  public BookingDetails(UUID bookingCarId, UUID bookingCustomerId, Date bookingStart, Date bookingEnd, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.bookingCarId = bookingCarId;
    this.bookingCustomerId = bookingCustomerId;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
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

  /**
   * Gets car model.
   *
   * @return the car model
   */
  public String getCarModel() {
    return carModel;
  }

  /**
   * Sets car model.
   *
   * @param carModel the car model
   */
  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }

  /**
   * Gets price per day.
   *
   * @return the price per day
   */
  public BigDecimal getPricePerDay() {
    return pricePerDay;
  }

  /**
   * Sets price per day.
   *
   * @param pricePerDay the price per day
   */
  public void setPricePerDay(BigDecimal pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  /**
   * Gets car type.
   *
   * @return the car type
   */
  public String getCarType() {
    return carType;
  }

  /**
   * Sets car type.
   *
   * @param carType the car type
   */
  public void setCarType(String carType) {
    this.carType = carType;
  }

  /**
   * Gets car availability.
   *
   * @return the car availability
   */
  public Boolean getCarAvailability() {
    return carAvailability;
  }

  /**
   * Sets car availability.
   *
   * @param carAvailability the car availability
   */
  public void setCarAvailability(Boolean carAvailability) {
    this.carAvailability = carAvailability;
  }

  /**
   * Gets customer name.
   *
   * @return the customer name
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * Sets customer name.
   *
   * @param customerName the customer name
   */
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  /**
   * Gets customer email.
   *
   * @return the customer email
   */
  public String getCustomerEmail() {
    return customerEmail;
  }

  /**
   * Sets customer email.
   *
   * @param customerEmail the customer email
   */
  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  /**
   * Gets customer phone.
   *
   * @return the customer phone
   */
  public String getCustomerPhone() {
    return customerPhone;
  }

  /**
   * Sets customer phone.
   *
   * @param customerPhone the customer phone
   */
  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  /**
   * Gets customer driver license.
   *
   * @return the customer driver license
   */
  public Boolean getCustomerDriverLicense() {
    return customerDriverLicense;
  }

  /**
   * Sets customer driver license.
   *
   * @param customerDriverLicense the customer driver license
   */
  public void setCustomerDriverLicense(Boolean customerDriverLicense) {
    this.customerDriverLicense = customerDriverLicense;
  }

  /**
   * Gets customer birth.
   *
   * @return the customer birth
   */
  public Date getCustomerBirth() {
    return customerBirth;
  }

  /**
   * Sets customer birth.
   *
   * @param customerBirth the customer birth
   */
  public void setCustomerBirth(Date customerBirth) {
    this.customerBirth = customerBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BookingDetails)) return false;
    BookingDetails that = (BookingDetails) o;
    return getBookingId().equals(that.getBookingId()) && getBookingCarId().equals(that.getBookingCarId()) && getBookingCustomerId().equals(that.getBookingCustomerId()) && getBookingStart().equals(that.getBookingStart()) && getBookingEnd().equals(that.getBookingEnd()) && getCarModel().equals(that.getCarModel()) && getPricePerDay().equals(that.getPricePerDay()) && getCarType().equals(that.getCarType()) && getCarAvailability().equals(that.getCarAvailability()) && getCustomerName().equals(that.getCustomerName()) && getCustomerEmail().equals(that.getCustomerEmail()) && getCustomerPhone().equals(that.getCustomerPhone()) && getCustomerDriverLicense().equals(that.getCustomerDriverLicense()) && getCustomerBirth().equals(that.getCustomerBirth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBookingId(), getBookingCarId(), getBookingCustomerId(), getBookingStart(), getBookingEnd(), getCarModel(), getPricePerDay(), getCarType(), getCarAvailability(), getCustomerName(), getCustomerEmail(), getCustomerPhone(), getCustomerDriverLicense(), getCustomerBirth());
  }

  @Override
  public String toString() {
    return "BookingDetails{" +
      "bookingId=" + bookingId +
      ", bookingCarId=" + bookingCarId +
      ", bookingCustomerId=" + bookingCustomerId +
      ", bookingStart=" + bookingStart +
      ", bookingEnd=" + bookingEnd +
      ", carModel='" + carModel + '\'' +
      ", pricePerDay=" + pricePerDay +
      ", carType='" + carType + '\'' +
      ", carAvailability=" + carAvailability +
      ", customerName='" + customerName + '\'' +
      ", customerEmail='" + customerEmail + '\'' +
      ", customerPhone='" + customerPhone + '\'' +
      ", customerDriverLicense=" + customerDriverLicense +
      ", customerBirth=" + customerBirth +
      '}';
  }
}
