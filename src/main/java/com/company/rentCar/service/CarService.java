package com.company.rentCar.service;

import com.company.rentCar.data.CarDTO;
import io.smallrye.mutiny.Uni;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

/**
 * The interface Car service.
 */
public interface CarService {

  /**
   * Find cars uni.
   *
   * @return the uni
   */
  Uni<List<CarDTO>> findCars();

  /**
   * Find car by id uni.
   *
   * @param carId the car id
   * @return the uni
   */
  Uni<CarDTO> findCarById(UUID carId);

  /**
   * Save car uni.
   *
   * @param carDTO the car dto
   * @return the uni
   */
  Uni<Void> saveCar(CarDTO carDTO);

  /**
   * Update car uni.
   *
   * @param carDTO the car dto
   * @return the uni
   */
  Uni<Integer> updateCar(CarDTO carDTO);

  /**
   * Delete car uni.
   *
   * @param carId the car id
   * @return the uni
   */
  Uni<Integer> deleteCar(UUID carId);
}
