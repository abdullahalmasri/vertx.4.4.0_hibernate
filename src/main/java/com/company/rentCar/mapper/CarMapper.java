package com.company.rentCar.mapper;

import com.company.rentCar.data.CarDTO;
import com.company.rentCar.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Car mapper.
 */
@Mapper
public interface CarMapper {

  /**
   * Car to car dto car dto.
   *
   * @param entity the entity
   * @return the car dto
   */
  @Mapping(target = "carId", source = "entity.carId")
  @Mapping(target = "carModel", source = "entity.carModel")
  @Mapping(target = "pricePerDay", source = "entity.pricePerDay")
  @Mapping(target = "carType", source = "entity.carType")
  @Mapping(target = "carAvailability", source = "entity.carAvailability")
  CarDTO carToCarDTO(Car entity);

  /**
   * Car dto to car car.
   *
   * @param dto the dto
   * @return the car
   */
  @Mapping(target = "carId", source = "dto.carId")
  @Mapping(target = "carModel", source = "dto.carModel")
  @Mapping(target = "pricePerDay", source = "dto.pricePerDay")
  @Mapping(target = "carType", source = "dto.carType")
  @Mapping(target = "carAvailability", source = "dto.carAvailability")
  Car carDTOToCar(CarDTO dto);
}
