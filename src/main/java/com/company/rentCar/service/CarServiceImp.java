package com.company.rentCar.service;

import com.company.rentCar.data.CarDTO;
import com.company.rentCar.mapper.CarMapper;
import com.company.rentCar.sql.CarRepository;
import io.vertx.core.Future;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarServiceImp implements CarService{
  private final CarRepository repository;

  public CarServiceImp(CarRepository repository) {
    this.repository = repository;
  }

  @Override
  public Future<List<CarDTO>> findCars() {
    List<CarDTO> result = new ArrayList<>() ;
    repository.findAllCar().result().forEach(car ->
      result.add(Mappers.getMapper(CarMapper.class).carToCarDTO(car))
    );
    return Future.succeededFuture(result);
  }

  @Override
  public Future<CarDTO> findCarById(UUID carId) {
    CarDTO carDTO =Mappers.getMapper(CarMapper.class).carToCarDTO(repository.findCarById(carId).result());
    return Future.succeededFuture(carDTO);
  }

  @Override
  public Future<CarDTO> saveCar(CarDTO carDTO) {
    repository.saveCar(Mappers.getMapper(CarMapper.class).carDTOToCar(carDTO));
    return Future.succeededFuture(carDTO);
  }

  @Override
  public Future<CarDTO> updateCar(CarDTO carDTO) {
    repository.updateCar(Mappers.getMapper(CarMapper.class).carDTOToCar(carDTO));
    return Future.succeededFuture(carDTO);
  }

  @Override
  public Future<Void> deleteCar(UUID carId) {
    repository.deleteCar(carId);
    return Future.succeededFuture();
  }
}
