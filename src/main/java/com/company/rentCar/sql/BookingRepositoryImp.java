package com.company.rentCar.sql;

import com.company.rentCar.model.Booking;
import io.vertx.core.Future;
import org.hibernate.reactive.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.*;

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
    } finally {
      factory.close();
    }

  }

  @Override
  public Future<Booking> findByBookingId(UUID bookingId) {
    try {
      Booking booking = factory.withSession(
        session -> session.find(Booking.class, bookingId))
        .toCompletableFuture().join();
      return Future.succeededFuture(booking);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    } finally {
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

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }

  }

  // not TypedQuery so need for .class
  @Override
  public Future<Booking> updateBooking(Booking booking) {
    try {

      factory.withTransaction((session, transaction) ->
        session.createQuery("update Booking d set d.bookingCarId='"+booking.getBookingCarId()
          +"',d.bookingCustomerId='"+booking.getBookingCustomerId()
          +"',d.bookingStart='"+booking.getBookingStart().toString()+"',d.bookingEnd='"+ booking.getBookingEnd().toString()+"' where bookingId ='"+booking.getBookingId()+"'")
          .executeUpdate()

      ).toCompletableFuture().join();
      return Future.succeededFuture(booking);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  // not TypedQuery so need for .class
  @Override
  public Future<Void> deleteBookingById(UUID bookingId) {
    try {
      int deleted = factory.withTransaction(
        (session, tx) -> session.createQuery(DELETE_BOOKING + bookingId+"'").executeUpdate()

      )
        .toCompletableFuture().join();
      if (deleted == 1) {
        System.out.println("yes");
      }
      return Future.succeededFuture(

      );
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }

  }


}
