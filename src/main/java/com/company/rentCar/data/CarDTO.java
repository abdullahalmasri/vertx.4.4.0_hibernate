package com.company.rentCar.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Car dto.
 */
public class CarDTO implements Serializable {
  private static final long serialVersionUID = 4L;

  private UUID carId;

  private String carModel;

  private BigDecimal pricePerDay;

  private String carType;

  private Boolean carAvailability;

  /**
   * Instantiates a new Car dto.
   */
  public CarDTO() {
  }

  /**
   * Instantiates a new Car dto.
   *
   * @param carId           the car id
   * @param carModel        the car model
   * @param pricePerDay     the price per day
   * @param carType         the car type
   * @param carAvailability the car availability
   */
  public CarDTO(UUID carId, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carId = carId;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
  }

  /**
   * Instantiates a new Car dto.
   *
   * @param carModel        the car model
   * @param pricePerDay     the price per day
   * @param carType         the car type
   * @param carAvailability the car availability
   */
  public CarDTO(String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
  }

  /**
   * Gets car id.
   *
   * @return the car id
   */
  public UUID getCarId() {
    return carId;
  }

  /**
   * Sets car id.
   *
   * @param carId the car id
   */
  public void setCarId(UUID carId) {
    this.carId = carId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CarDTO)) return false;
    CarDTO carDTO = (CarDTO) o;
    return getCarId().equals(carDTO.getCarId()) && getCarModel().equals(carDTO.getCarModel()) && getPricePerDay().equals(carDTO.getPricePerDay()) && getCarType().equals(carDTO.getCarType()) && getCarAvailability().equals(carDTO.getCarAvailability());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarId(), getCarModel(), getPricePerDay(), getCarType(), getCarAvailability());
  }

  @Override
  public String toString() {
    return "CarDTO{" +
      "carId=" + carId +
      ", carModel='" + carModel + '\'' +
      ", pricePerDay=" + pricePerDay +
      ", carType='" + carType + '\'' +
      ", carAvailability=" + carAvailability +
      '}';
  }
}
