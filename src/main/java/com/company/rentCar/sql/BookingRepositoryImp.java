package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;
import org.hibernate.reactive.stage.Stage;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_BOOKING;

public class BookingRepositoryImp implements BookingRepository{

  private final Stage.SessionFactory factory;

  public BookingRepositoryImp(Stage.SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public Future<List<Booking>> findAll() {
    CompletionStage<List<Booking>> stage = factory.withSession(session -> {
      return session.createNativeQuery(SELECT_ALL_BOOKING,Booking.class).getResultList();
    });
    return Future.fromCompletionStage(stage);
  }
}
