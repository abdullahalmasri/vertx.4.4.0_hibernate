package com.company.rentCar.router;

import com.company.rentCar.handler.BookingHandler;
import com.company.rentCar.service.BookingService;
import com.company.rentCar.service.BookingServiceImp;
import com.company.rentCar.sql.BookingRepository;
import com.company.rentCar.sql.BookingRepositoryImp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerFormat;
import io.vertx.ext.web.handler.LoggerHandler;
import org.hibernate.reactive.stage.Stage;

import javax.persistence.Persistence;

public class BookingRouter {
  private static final String APPLICATION_JSON = "application/json";
  private final BookingHandler handler;
  private final Vertx vertx;

  public BookingRouter(BookingHandler handler, Vertx vertx) {
    this.handler = handler;
    this.vertx = vertx;
  }

  public void setRouter(Router router) {
    router.mountSubRouter("/", buildBookRouter());
  }

  private Router buildBookRouter() {
    final Router router = Router.router(vertx);
    router.route("booking").handler(LoggerHandler.create());
    router.get("booking").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(handler::readAll);
    router.get("booking/:id").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(handler::readOne);
    router.post("booking").consumes(APPLICATION_JSON).handler(BodyHandler.create()).handler(
      handler::create
    );
    router.put("booking/:id").consumes(APPLICATION_JSON).handler(BodyHandler.create()).handler(
      handler::update
    );
    router.delete("booking/:id").handler(
      handler::delete
    );
    router.get("booking/details/:id").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(
      handler::getDetails
    );

    return router;

  }


//  public static void main(String[] args) {
//
//    Stage.SessionFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName(args))
//      .unwrap(Stage.SessionFactory.class);
//    // 3. Project repository
//    BookingRepository projectRepository = new BookingRepositoryImp(emf);
//
//    // 4. Project service
//    BookingService projectService = new BookingServiceImp(projectRepository);
//    BookingHandler bookingHandler = new BookingHandler(projectService);
//
//    // 5. WebVerticle
//    BookingRouter verticle = new BookingRouter(bookingHandler);
//
//
////    Vertx vertx = Vertx.vertx();
////    vertx.deployVerticle(verticle, options)
////      .onFailure(err -> err.printStackTrace())
////      .onSuccess(res -> {
////        System.out.println(res);
////        System.out.println("Application is up and running");
////      });
//  }
//
//
//  /**
//   * Return the persistence unit name to use in the example.
//   *
//   * @param args the first element is the persistence unit name if present
//   * @return the selected persistence unit name or the default one
//   */
//  public static String persistenceUnitName(String[] args) {
//    return args.length > 0 ? args[0] : "postgresql-example";
//  }
//
//}
}
