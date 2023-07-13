package com.company.rentCar.sql;

import com.company.rentCar.model.Car;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.DELETE_CAR;
import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_CAR;

/**
 * The type Car repository imp.
 */
public class CarRepositoryImp implements CarRepository, Serializable {

  private static final long serialVersionUID = 8787L;

  private final Mutiny.SessionFactory factory;

  /**
   * Instantiates a new Car repository imp.
   *
   * @param factory the factory
   */
  public CarRepositoryImp(Mutiny.SessionFactory factory) {
    this.factory = Persistence
      .createEntityManagerFactory("postgresql-example")
      .unwrap(Mutiny.SessionFactory.class);
  }

  @Override
  public Uni<List<Car>> findAllCar() {

    try {
      return factory.withSession(
        session -> session.createQuery(SELECT_ALL_CAR, Car.class)
          .getResultList()).onItem()
        .ifNotNull()
        .transform(cars -> cars);


    } catch (Exception e) {
      e.printStackTrace();
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Car> findCarById(UUID carId) {
    try {
      return factory.withSession(session -> session.find(Car.class, carId))
        .onItem().ifNull().continueWith(Car::new);
    } catch (Exception e) {
      e.printStackTrace();
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Void> saveCar(Car car) {
    try {
      return factory.withTransaction(session ->
        session.persist(car));
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Integer> updateCar(Car car) {
    try {
      return factory.withTransaction((session, transaction) ->
        session.createQuery("update Car cc set cc.carModel=" + car.getCarModel() +
          ",cc.pricePerDay=" + car.getPricePerDay() + ",cc.carType=" + car.getCarType() +
          ",cc.carAvailability=" + car.getCarAvailability() + " where carId='" + car.getCarId() + "'")
          .executeUpdate()
      );

    } catch (Exception e) {
      e.printStackTrace();
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Integer> deleteCar(UUID carId) {
    try {
      return factory.withTransaction(
        (session, transaction) -> session.createQuery(DELETE_CAR + carId + "'").executeUpdate()
      );

    } catch (Exception e) {
      e.printStackTrace();
      return Uni.createFrom().failure(e);
    }
  }
}
