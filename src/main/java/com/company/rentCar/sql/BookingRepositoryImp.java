package com.company.rentCar.sql;

import com.company.rentCar.data.BookingDetails;
import com.company.rentCar.data.CustomerAndCarDetails;
import com.company.rentCar.model.Booking;
import io.smallrye.mutiny.Uni;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.DELETE_BOOKING;
import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_BOOKING;

/**
 * The type Booking repository imp.
 */
public class BookingRepositoryImp implements BookingRepository, Serializable {

  private static final long serialVersionUID = 888L;
  private static final Logger logger = LoggerFactory.getLogger(BookingRepositoryImp.class);

  private final Mutiny.SessionFactory factory;

  /**
   * Instantiates a new Booking repository imp.
   */
  public BookingRepositoryImp() {
    this.factory = Persistence
      .createEntityManagerFactory("postgresql-example")
      .unwrap(Mutiny.SessionFactory.class);
  }

  @Override
  public Uni<List<Booking>> findAll() {
    try {
      return factory.withSession(
        session -> session
          .createQuery(SELECT_ALL_BOOKING, Booking.class)
          .getResultList())
        .onItem()
        .ifNotNull()
        .transform(bookings -> bookings);
    } catch (Exception e) {
      logger.info(e.getMessage());
      return Uni.createFrom().failure(e);
    }

  }

  @Override
  public Uni<Booking> findByBookingId(UUID bookingId) {
    try {
      return factory.withSession(
        session -> session.find(Booking.class, bookingId))
        .onItem().ifNull().continueWith(new Booking());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Uni.createFrom().failure(e);
    }

  }

  @Override
  public Uni<Void> saveBooking(Booking booking) {
    try {

      return factory.withTransaction(session ->
        session.persist(booking)
      );

    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }

  }

  // not TypedQuery so no need for .class
  @Override
  public Uni<Integer> updateBooking(Booking booking) {
    try {
      return
        factory.withTransaction((session, transaction) ->
          session.createQuery("update Booking d set d.bookingCarId='" + booking.getBookingCarId()
            + "',d.bookingCustomerId='" + booking.getBookingCustomerId()
            + "',d.bookingStart='" + booking.getBookingStart().toString() +
            "',d.bookingEnd='" + booking.getBookingEnd().toString() +
            "' where bookingId ='" + booking.getBookingId() + "'")
            .executeUpdate()
        );

    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  // not TypedQuery so no need for .class
  @Override
  public Uni<Integer> deleteBookingById(UUID bookingId) {
    try {
      return factory.withTransaction(
        (session, tx) -> session.createQuery(DELETE_BOOKING + bookingId + "'").executeUpdate()

      );

    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }

  }

  @Override
  public Uni<BookingDetails> findBookingDetailsById(UUID bookingId) {

    try {


      return factory.withSession(session ->
        session.createQuery(
          "SELECT new com.company.rentCar.data.BookingDetails(b.bookingId,c.customerId,cc.carId,b.bookingStart,b.bookingEnd," +
            "cc.carModel,cc.pricePerDay,cc.carType,cc.carAvailability" +
            ",c.customerName,c.customerEmail,c.customerPhone,c.customerDriverLicense,c.customerBirth" +
            ") from Booking b INNER join Customer  c ON " +
            "b.bookingCustomerId=c.customerId " +
            "INNER join Car cc ON b.bookingCarId=cc.carId " +
            "where b.bookingId='" + bookingId + "'", BookingDetails.class).getSingleResult()
          .onItem().ifNull().continueWith(BookingDetails::new)
      );
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<CustomerAndCarDetails> findDetailsOfCustomerAndCarByIds(UUID customerId, UUID carId) {
    try {


      return factory.withSession(session ->
        session.createQuery(
          "SELECT new com.company.rentCar.data.CustomerAndCarDetails(cc.carId," +
            "cc.carModel,cc.pricePerDay,cc.carType,cc.carAvailability," +
            " c.customerId,c.customerName,c.customerEmail,c.customerPhone," +
            "c.customerDriverLicense,c.customerBirth" +
            ") from Car cc, Customer c" +
            " where cc.carId ='"+carId+"' and c.customerId ='"+customerId+"'",
          CustomerAndCarDetails.class).getSingleResultOrNull()
      );
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }


}
