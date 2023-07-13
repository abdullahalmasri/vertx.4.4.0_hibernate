package com.company.rentCar.handler;

import com.company.rentCar.data.CarDTO;
import com.company.rentCar.service.CarService;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.ext.web.RoutingContext;

import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

/**
 * The type Car handler.
 */
public class CarHandler {

  private final CarService service;

  /**
   * Instantiates a new Car handler.
   *
   * @param service the service
   */
  public CarHandler(CarService service) {
    this.service = service;
  }

  /**
   * Read all uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<List<CarDTO>> readAll(RoutingContext rc) {
    return service.findCars();
  }

  /**
   * Read one uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<CarDTO> readOne(RoutingContext rc) {
    return service.findCarById(UUID.fromString(getId(rc)));
  }

  /**
   * Create uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Void> create(RoutingContext rc) {

    return service.saveCar(rc.body().asJsonObject().mapTo(CarDTO.class));
  }

  /**
   * Update uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> update(RoutingContext rc) {
    UUID carId = UUID.fromString(getId(rc));
    CarDTO dto = rc.body().asJsonObject().mapTo(CarDTO.class);
    dto.setCarId(carId);
    return service.updateCar(dto);
  }

  /**
   * Delete uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> delete(RoutingContext rc) {
    return
      service.deleteCar(UUID.fromString(getId(rc)));
  }

  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
