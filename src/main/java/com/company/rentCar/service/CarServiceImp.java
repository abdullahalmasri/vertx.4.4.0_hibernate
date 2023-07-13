package com.company.rentCar.service;

import com.company.rentCar.data.CarDTO;
import com.company.rentCar.mapper.CarMapper;
import com.company.rentCar.sql.CarRepository;
import io.smallrye.mutiny.Uni;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Car service imp.
 */
public class CarServiceImp implements CarService, Serializable {
  private static final long serialVersionUID = 88L;
  private final CarRepository repository;

  /**
   * Instantiates a new Car service imp.
   *
   * @param repository the repository
   */
  public CarServiceImp(CarRepository repository) {
    this.repository = repository;
  }

  @Override
  public Uni<List<CarDTO>> findCars() {
    Uni<List<CarDTO>> result = repository.findAllCar()
      .onItem()
      .transform(cars -> cars
        .stream()
        .map(car ->
          Mappers.getMapper(CarMapper.class).carToCarDTO(car)
        )
        .collect(Collectors.toList())
      );
    return result;
  }

  @Override
  public Uni<CarDTO> findCarById(UUID carId) {
    Uni<CarDTO> carDTO = repository.findCarById(carId)
      .onItem()
      .ifNotNull()
      .transform(car ->
        Mappers.getMapper(CarMapper.class).carToCarDTO(car)
      );
    return carDTO;
  }

  @Override
  public Uni<Void> saveCar(CarDTO carDTO) {

    if (carDTO.getCarId() == null) {
      carDTO.setCarId(UUID.randomUUID());
    }
    return repository.saveCar(Mappers.getMapper(CarMapper.class).carDTOToCar(carDTO));
  }

  @Override
  public Uni<Integer> updateCar(CarDTO carDTO) {
    if (carDTO.getCarId() == null) {
      return null;
    }
    Uni<Integer> success = repository.updateCar(Mappers.getMapper(CarMapper.class).carDTOToCar(carDTO));
    return success;
  }

  @Override
  public Uni<Integer> deleteCar(UUID carId) {
    return repository.deleteCar(carId);
  }
}
