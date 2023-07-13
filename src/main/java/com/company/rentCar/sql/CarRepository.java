package com.company.rentCar.sql;

import com.company.rentCar.model.Car;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

/**
 * The interface Car repository.
 */
public interface CarRepository {

  /**
   * Find all car uni.
   *
   * @return the uni
   */
  Uni<List<Car>> findAllCar();

  /**
   * Find car by id uni.
   *
   * @param carId the car id
   * @return the uni
   */
  Uni<Car> findCarById(UUID carId);

  /**
   * Save car uni.
   *
   * @param car the car
   * @return the uni
   */
  Uni<Void> saveCar(Car car);

  /**
   * Update car uni.
   *
   * @param car the car
   * @return the uni
   */
  Uni<Integer> updateCar(Car car);

  /**
   * Delete car uni.
   *
   * @param carId the car id
   * @return the uni
   */
  Uni<Integer> deleteCar(UUID carId);
}
