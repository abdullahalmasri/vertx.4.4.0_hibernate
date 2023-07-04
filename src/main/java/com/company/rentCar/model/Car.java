package com.company.rentCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "car_tb")
public class Car {

  @Id
  @Column(name = "car_id",nullable = false)
  private UUID carId;
  @Column(name = "car_model",nullable = false)
  private String carModel;
  @Column(name = "car_price_per_day",nullable = false)
  private BigDecimal pricePerDay;
  @Column(name = "car_type",nullable = false)
  private String carType;
  @Column(name = "car_availability",nullable = false)
  private Boolean carAvailability;


  public Car() {
  }

  public Car(String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
  }

  public Car(UUID carId, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carId = carId;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
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
