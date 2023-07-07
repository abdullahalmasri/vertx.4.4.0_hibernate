package com.company.rentCar.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class BookingDetails {
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

  public BookingDetails() {
  }

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

  public String getCarModel() {
    return carModel;
  }

  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }

  public BigDecimal getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(BigDecimal pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public Boolean getCarAvailability() {
    return carAvailability;
  }

  public void setCarAvailability(Boolean carAvailability) {
    this.carAvailability = carAvailability;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public Boolean getCustomerDriverLicense() {
    return customerDriverLicense;
  }

  public void setCustomerDriverLicense(Boolean customerDriverLicense) {
    this.customerDriverLicense = customerDriverLicense;
  }

  public Date getCustomerBirth() {
    return customerBirth;
  }

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
