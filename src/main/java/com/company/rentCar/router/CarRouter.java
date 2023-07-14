package com.company.rentCar.router;

import com.company.rentCar.handler.CarHandler;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.Router;
import io.vertx.mutiny.ext.web.handler.BodyHandler;
import io.vertx.mutiny.ext.web.handler.LoggerHandler;

import static com.company.rentCar.Constrant.ConstrantQuery.APPLICATION_JSON;

/**
 * The type Car router.
 */
public class CarRouter implements AbstractRouter{
  private final CarHandler handler;
  private final Vertx vertx;

  /**
   * Instantiates a new Car router.
   *
   * @param handler the handler
   * @param vertx   the vertx
   */
  public CarRouter(CarHandler handler, Vertx vertx) {
    this.handler = handler;
    this.vertx = vertx;
  }

  /**
   * Sets router.
   *
   * @param router the router
   */
@Override 
  public void setRouter(Router router) {
    router.mountSubRouter("/api/v1", buildBookRouter());
  }

  private Router buildBookRouter() {
    final Router router = Router.router(vertx);
    router.route("/car").handler(LoggerHandler.create());
    router.get("/car").respond(handler::readAll);
    router.get("/car/:id").respond(handler::readOne);
    router.post("/car").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::create
    );
    router.put("/car/:id").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::update
    );
    router.delete("/car/:id").respond(
      handler::delete
    );
    return router;
  }
}
