package com.company.rentCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Car.
 */
@Entity
@Table(name = "car_tb")
public class Car implements Serializable {

  private static final long serialVersionUID = 2L;

  @Id
  @Column(name = "car_id", nullable = false)
  private UUID carId;
  @Column(name = "car_model", nullable = false)
  private String carModel;
  @Column(name = "car_price_per_day", nullable = false)
  private BigDecimal pricePerDay;
  @Column(name = "car_type", nullable = false)
  private String carType;
  @Column(name = "car_availability", nullable = false)
  private Boolean carAvailability;


  /**
   * Instantiates a new Car.
   */
  public Car() {
  }

  /**
   * Instantiates a new Car.
   *
   * @param carModel        the car model
   * @param pricePerDay     the price per day
   * @param carType         the car type
   * @param carAvailability the car availability
   */
  public Car(String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
  }

  /**
   * Instantiates a new Car.
   *
   * @param carId           the car id
   * @param carModel        the car model
   * @param pricePerDay     the price per day
   * @param carType         the car type
   * @param carAvailability the car availability
   */
  public Car(UUID carId, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carId = carId;
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
    if (!(o instanceof Car)) return false;
    Car car = (Car) o;
    return getCarId().equals(car.getCarId()) && getCarModel().equals(car.getCarModel()) && getPricePerDay().equals(car.getPricePerDay()) && getCarType().equals(car.getCarType()) && getCarAvailability().equals(car.getCarAvailability());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarId(), getCarModel(), getPricePerDay(), getCarType(), getCarAvailability());
  }

  @Override
  public String toString() {
    return "Car{" +
      "carId=" + carId +
      ", carModel='" + carModel + '\'' +
      ", pricePerDay=" + pricePerDay +
      ", carType='" + carType + '\'' +
      ", carAvailability=" + carAvailability +
      '}';
  }
}
