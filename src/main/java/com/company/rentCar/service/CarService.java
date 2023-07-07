package com.company.rentCar.service;

import com.company.rentCar.data.CarDTO;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface CarService {

  Future<List<CarDTO>> findCars();

  Future<CarDTO> findCarById(UUID carId);

  Future<CarDTO> saveCar(CarDTO carDTO);

  Future<CarDTO> updateCar(CarDTO carDTO);

  Future<Void> deleteCar(UUID carId);
}
