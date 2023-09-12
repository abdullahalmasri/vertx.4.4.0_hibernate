package com.company.rentCar.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class CustomerAndCarDetails {
  private UUID carId;

  private String carModel;

  private BigDecimal pricePerDay;

  private String carType;

  private Boolean carAvailability;

  private UUID customerId;

  private String customerName;

  private String customerEmail;

  private String customerPhone;

  private Boolean customerDriverLicense;

  private Date customerBirth;

  public CustomerAndCarDetails() {
  }

  public CustomerAndCarDetails(CustomerAndCarDetails customerAndCarDetails) {
    this.carId=customerAndCarDetails.getCarId();
    this.carModel=customerAndCarDetails.getCarModel();
    this.carType=customerAndCarDetails.getCarType();
    this.carAvailability=customerAndCarDetails.getCarAvailability();
    this.customerId=customerAndCarDetails.getCustomerId();
    this.customerName=customerAndCarDetails.getCustomerName();
    this.customerEmail=customerAndCarDetails.getCustomerEmail();
    this.customerPhone=customerAndCarDetails.getCustomerPhone();
    this.customerBirth=customerAndCarDetails.getCustomerBirth();
    this.customerDriverLicense=customerAndCarDetails.getCustomerDriverLicense();
  }


  public CustomerAndCarDetails(UUID carId, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability, UUID customerId, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.carId = carId;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }

  public UUID getCarId() {
    return carId;
  }

  public void setCarId(UUID carId) {
    this.carId = carId;
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

  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
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
    if (!(o instanceof CustomerAndCarDetails)) return false;
    CustomerAndCarDetails that = (CustomerAndCarDetails) o;
    return getCarId().equals(that.getCarId()) && getCarModel().equals(that.getCarModel()) && getPricePerDay().equals(that.getPricePerDay()) && getCarType().equals(that.getCarType()) && getCarAvailability().equals(that.getCarAvailability()) && getCustomerId().equals(that.getCustomerId()) && getCustomerName().equals(that.getCustomerName()) && getCustomerEmail().equals(that.getCustomerEmail()) && getCustomerPhone().equals(that.getCustomerPhone()) && getCustomerDriverLicense().equals(that.getCustomerDriverLicense()) && getCustomerBirth().equals(that.getCustomerBirth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarId(), getCarModel(), getPricePerDay(), getCarType(), getCarAvailability(), getCustomerId(), getCustomerName(), getCustomerEmail(), getCustomerPhone(), getCustomerDriverLicense(), getCustomerBirth());
  }

  @Override
  public String toString() {
    return "CustomerAndCarDetails{" +
      "carId=" + carId +
      ", carModel='" + carModel + '\'' +
      ", pricePerDay=" + pricePerDay +
      ", carType='" + carType + '\'' +
      ", carAvailability=" + carAvailability +
      ", customerId=" + customerId +
      ", customerName='" + customerName + '\'' +
      ", customerEmail='" + customerEmail + '\'' +
      ", customerPhone='" + customerPhone + '\'' +
      ", customerDriverLicense=" + customerDriverLicense +
      ", customerBirth=" + customerBirth +
      '}';
  }
}
