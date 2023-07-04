package com.company.rentCar.data;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class CarDTO {
  private UUID carId;

  private String carModel;

  private BigDecimal pricePerDay;

  private String carType;

  private Boolean carAvailability;

  public CarDTO() {
  }

  public CarDTO(UUID carId, String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
    this.carId = carId;
    this.carModel = carModel;
    this.pricePerDay = pricePerDay;
    this.carType = carType;
    this.carAvailability = carAvailability;
  }

  public CarDTO(String carModel, BigDecimal pricePerDay, String carType, Boolean carAvailability) {
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
