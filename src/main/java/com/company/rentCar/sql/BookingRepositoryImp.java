package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;
import org.hibernate.SessionFactory;
import org.hibernate.reactive.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_BOOKING;

public class BookingRepositoryImp implements BookingRepository {

  private final Stage.SessionFactory factory;

  public BookingRepositoryImp(Stage.SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public Future<List<Booking>> findAll() {
    try {
      List<Booking> bookingList = new ArrayList<>();
        factory.withSession(
        session -> session.createQuery(SELECT_ALL_BOOKING, Booking.class)
          .getResultList().thenAccept(bookingList::addAll)).toCompletableFuture().join();

      return Future.succeededFuture(bookingList);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    }

//     List<Booking> bookingList = new ArrayList<>();
//     bookingList.addAll(stage.getResultList());


  }

  @Override
  public Future<Booking> findByBookingId(UUID bookingId) {
    return null;
  }


  public void closeFactory() {
    factory.close();
  }
}
