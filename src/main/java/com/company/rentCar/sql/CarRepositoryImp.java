package com.company.rentCar.sql;

import com.company.rentCar.model.Car;
import io.vertx.core.Future;
import org.hibernate.reactive.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.DELETE_CAR;
import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_CAR;

public class CarRepositoryImp  implements CarRepository{

  private final Stage.SessionFactory factory;

  public CarRepositoryImp(Stage.SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public Future<List<Car>> findAllCar() {

    try {
      List<Car> cars = new ArrayList<>();
      factory.withSession(
        session ->session.createQuery(SELECT_ALL_CAR,Car.class)
      .getResultList().thenAccept(cars::addAll)
      ).toCompletableFuture().join();
      return Future.succeededFuture(cars);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Car> findCarById(UUID carId) {
    try {
      Car car = factory.withSession(session -> session.find(Car.class, carId))
        .toCompletableFuture().get();
      return Future.succeededFuture(car);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Car> saveCar(Car car) {
    try {
      factory.withTransaction((session, transaction) ->
        session.persist(car)).toCompletableFuture().join();
      return Future.succeededFuture(car);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Car> updateCar(Car car) {
    try {
      factory.withTransaction((session, transaction) ->
        session.createQuery("update Car cc set cc.carModel="+car.getCarModel()+
          ",cc.pricePerDay="+car.getPricePerDay()+",cc.carType="+car.getCarType()+
          ",cc.carAvailability="+car.getCarAvailability()+" where carId='"+car.getCarId()+"'")
      .executeUpdate()
      ).toCompletableFuture().join();

      return Future.succeededFuture(car);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Void> deleteCar(UUID carId) {
    try {
      int deleted  = factory.withTransaction(
        (session, transaction) -> session.createQuery(DELETE_CAR+carId+"'").executeUpdate()
      ).toCompletableFuture().join();
      if (deleted == 1) {
        System.out.println("deleteCar");
      }
      return Future.succeededFuture();
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }
}
