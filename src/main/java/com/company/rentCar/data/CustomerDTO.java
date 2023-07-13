package com.company.rentCar.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Customer dto.
 */
public class CustomerDTO implements Serializable {

  private static final long serialVersionUID = 6L;
  private UUID customerId;

  private String customerName;

  private String customerEmail;

  private String customerPhone;

  private Boolean customerDriverLicense;

  private Date customerBirth;


  /**
   * Instantiates a new Customer dto.
   */
  public CustomerDTO() {
  }

  /**
   * Instantiates a new Customer dto.
   *
   * @param customerId            the customer id
   * @param customerName          the customer name
   * @param customerEmail         the customer email
   * @param customerPhone         the customer phone
   * @param customerDriverLicense the customer driver license
   * @param customerBirth         the customer birth
   */
  public CustomerDTO(UUID customerId, String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }

  /**
   * Instantiates a new Customer dto.
   *
   * @param customerName          the customer name
   * @param customerEmail         the customer email
   * @param customerPhone         the customer phone
   * @param customerDriverLicense the customer driver license
   * @param customerBirth         the customer birth
   */
  public CustomerDTO(String customerName, String customerEmail, String customerPhone, Boolean customerDriverLicense, Date customerBirth) {
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.customerDriverLicense = customerDriverLicense;
    this.customerBirth = customerBirth;
  }


  /**
   * Gets customer id.
   *
   * @return the customer id
   */
  public UUID getCustomerId() {
    return customerId;
  }

  /**
   * Sets customer id.
   *
   * @param customerId the customer id
   */
  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
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
