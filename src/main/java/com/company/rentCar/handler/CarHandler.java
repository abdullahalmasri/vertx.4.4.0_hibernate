package com.company.rentCar.handler;

import com.company.rentCar.data.CarDTO;
import com.company.rentCar.service.CarService;
import com.company.rentCar.utils.ResponseUtils;
import io.vertx.core.Future;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

public class CarHandler {

  private final CarService service;

  public CarHandler(CarService service) {
    this.service = service;
  }

  public Future<List<CarDTO>> readAll(RoutingContext rc) {
    List<CarDTO> cars = new ArrayList<>();
    return service.findCars()
      .onSuccess(success ->{
        cars.addAll(success);
        ResponseUtils.buildOkResponse(rc, success);
      } );
  }

  public Future<CarDTO> readOne(RoutingContext rc) {
    return service.findCarById(UUID.fromString(getId(rc)))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<CarDTO> create(RoutingContext rc) {

    return service.saveCar(rc.body().asJsonObject().mapTo(CarDTO.class))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<CarDTO> update(RoutingContext rc) {
    UUID carId = UUID.fromString(getId(rc));
    CarDTO dto = rc.body().asJsonObject().mapTo(CarDTO.class);
    dto.setCarId(carId);
    return service.updateCar(dto)
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<Void> delete(RoutingContext rc) {
    return
      service.deleteCar(UUID.fromString(getId(rc)))
        .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
        .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
