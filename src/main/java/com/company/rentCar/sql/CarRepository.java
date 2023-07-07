package com.company.rentCar.sql;

import com.company.rentCar.model.Car;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface CarRepository {

  Future<List<Car>> findAllCar();

  Future<Car> findCarById(UUID carId);

  Future<Car> saveCar(Car car);

  Future<Car> updateCar(Car car);

  Future<Void> deleteCar(UUID carId);
}
