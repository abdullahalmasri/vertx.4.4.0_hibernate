package com.company.rentCar;

import com.company.rentCar.handler.BookingHandler;
import com.company.rentCar.handler.CarHandler;
import com.company.rentCar.handler.CustomerHandler;
import com.company.rentCar.router.*;
import com.company.rentCar.service.*;
import com.company.rentCar.sql.*;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.http.HttpServer;
import io.vertx.mutiny.ext.web.Router;
import org.hibernate.reactive.mutiny.Mutiny;

public class MainVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
  private Mutiny.SessionFactory emf;  // <1>


  @Override
  public Uni<Void> asyncStart() {
// end::preamble[]

    // tag::hr-start[]
    Uni<Void> startHibernate = Uni.createFrom().deferred(() -> {

      return Uni.createFrom().voidItem();
    });

    startHibernate = vertx.executeBlocking(startHibernate)  // <2>
      .onItem().invoke(() -> LOGGER.info("✅ Hibernate Reactive is ready"));
    // end::hr-start[]




    // tag::async-start[]
    Uni<HttpServer> startHttpServer = vertx.createHttpServer()
      .requestHandler(startApp(vertx))
      .listen(8888)
      .onItem().invoke(() -> LOGGER.info("✅ HTTP server listening on port 8888"));

    return Uni.combine().all().unis(startHibernate, startHttpServer).discardItems();  // <1>
    // end::async-start[]
  }

  private Router startApp(Vertx vertx) {
    final Router router = Router.router(vertx);

    final BookingRepository bookingRepository = new BookingRepositoryImp();
    final CarRepository carRepository = new CarRepositoryImp(emf);
    final CustomerRepository customerRepository = new CustomerRepositoryImp(emf);
    final BookingService bookingService = new BookingServiceImp(bookingRepository);
    final CarService carService = new CarServiceImp(carRepository);
    final CustomerService customerService = new CustomerServiceImp(customerRepository);
    final BookingHandler bookingHandler = new BookingHandler(bookingService);
    final CarHandler carHandler = new CarHandler(carService);
    final CustomerHandler customerHandler = new CustomerHandler(customerService);
    MainRouter mainRouter = new MainRouter(router,vertx, bookingHandler, customerHandler, carHandler);
    mainRouter.setBookingRouter();
    mainRouter.setCustomerRouter();
    mainRouter.setCarRouter();
    return router;
  }


}
