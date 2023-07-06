package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import com.company.rentCar.model.Customer;
import io.vertx.core.Future;
import org.hibernate.reactive.stage.Stage;

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

  }

  @Override
  public Future<Booking> findByBookingId(UUID bookingId) {
    try {
      Booking booking=factory.withSession(
        session -> session.find(Booking.class, bookingId))
        .toCompletableFuture().join();
      return Future.succeededFuture(booking);
    }catch(Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    }finally {
      factory.close();
    }

  }

  @Override
  public Future<Booking> saveBooking(Booking booking) {
    try {
      factory.withTransaction(
        (session, transaction) -> session.persist(booking)).toCompletableFuture().join();
      return Future.succeededFuture(
        booking
        );

    }catch (Exception e){
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    }finally {
      factory.close();
    }

  }

  @Override
  public Future<Booking> updateBooking(Booking booking) {
    return null;
  }


}
