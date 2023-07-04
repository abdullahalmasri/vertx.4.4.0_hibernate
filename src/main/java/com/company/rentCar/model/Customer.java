package com.company.rentCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cutomer_tb")
public class Customer {

  @Id
  @Column(name = "customer_id",nullable = false)
  private UUID customerId;

  @Column(name = "customer_name",nullable = false,unique = true)
  private String customerName;

  @Column(name = "customer_email",nullable = true)
  private String customerEmail;

  @Column(name = "customer_phone",nullable = true)
  private String customerPhone;

  @Column(name = "customer_driver_license",nullable = false)
  private Boolean customerDriverLicense;

  @Column(name = "customer_birth",nullable = false)
  private Date customerBirth;

  public Customer() {
  }

  public Customer(UUID customerId, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }

  public Customer(String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
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
    if (!(o instanceof Customer)) return false;
    Customer customer = (Customer) o;
    return getCustomerId().equals(customer.getCustomerId()) && getCustomerName().equals(customer.getCustomerName()) && getCustomerEmail().equals(customer.getCustomerEmail()) && getCustomerPhone().equals(customer.getCustomerPhone()) && getCustomerDriverLicense().equals(customer.getCustomerDriverLicense()) && getCustomerBirth().equals(customer.getCustomerBirth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCustomerId(), getCustomerName(), getCustomerEmail(), getCustomerPhone(), getCustomerDriverLicense(), getCustomerBirth());
  }

  @Override
  public String toString() {
    return "Customer{" +
      "customerId=" + customerId +
      ", customerName='" + customerName + '\'' +
      ", customerEmail='" + customerEmail + '\'' +
      ", customerPhone='" + customerPhone + '\'' +
      ", customerDriverLicense=" + customerDriverLicense +
      ", customerBirth=" + customerBirth +
      '}';
  }
}
