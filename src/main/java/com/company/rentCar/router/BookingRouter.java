package com.company.rentCar.router;

import com.company.rentCar.handler.BookingHandler;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.Router;
import io.vertx.mutiny.ext.web.handler.BodyHandler;
import io.vertx.mutiny.ext.web.handler.LoggerHandler;

import static com.company.rentCar.Constrant.ConstrantQuery.APPLICATION_JSON;

/**
 * The type Booking router.
 */
public class BookingRouter implement AbstractRouter {
  private final BookingHandler handler;
  private final Vertx vertx;

  /**
   * Instantiates a new Booking router.
   *
   * @param handler the handler
   * @param vertx   the vertx
   */
  public BookingRouter(BookingHandler handler, Vertx vertx) {
    this.handler = handler;
    this.vertx = vertx;
  }

  /**
   * Sets router.
   *
   * @param router the router
   */
@override 
  public void setRouter(Router router) {
    router.mountSubRouter("/api/v1", buildBookRouter());
  }

  /**
   * Build book router router.
   *
   * @return the router
   */
  public Router buildBookRouter() {
//    HttpServer server = vertx.createHttpServer();
    final Router router = Router.router(vertx);
    router.route("/booking").handler(LoggerHandler.create());
    router.get("/booking").respond(handler::readAll);
    router.get("/booking/:id").respond(handler::readOne);
    router.post("/booking").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::create
    );
    router.put("/booking/:id").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::update
    );
    router.delete("/booking/:id").respond(
      handler::delete
    );
    router.get("/booking/details/:id").respond(
      handler::getDetails
    );
    return router;

  }
}
