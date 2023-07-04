package com.company.rentCar.data;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class CustomerDTO {


  private UUID customerId;

  private String customerName;

  private String customerEmail;

  private String customerPhone;

  private Boolean customerDriverLicense;

  private Date customerBirth;


  public CustomerDTO() {
  }

  public CustomerDTO(UUID customerId, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }

  public CustomerDTO(String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
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
    if (!(o instanceof CustomerDTO)) return false;
    CustomerDTO that = (CustomerDTO) o;
    return getCustomerId().equals(that.getCustomerId()) && getCustomerName().equals(that.getCustomerName()) && getCustomerEmail().equals(that.getCustomerEmail()) && getCustomerPhone().equals(that.getCustomerPhone()) && getCustomerDriverLicense().equals(that.getCustomerDriverLicense()) && getCustomerBirth().equals(that.getCustomerBirth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCustomerId(), getCustomerName(), getCustomerEmail(), getCustomerPhone(), getCustomerDriverLicense(), getCustomerBirth());
  }

  @Override
  public String toString() {
    return "CustomerDTO{" +
      "customerId=" + customerId +
      ", customerName='" + customerName + '\'' +
      ", customerEmail='" + customerEmail + '\'' +
      ", customerPhone='" + customerPhone + '\'' +
      ", customerDriverLicense=" + customerDriverLicense +
      ", customerBirth=" + customerBirth +
      '}';
  }
}
