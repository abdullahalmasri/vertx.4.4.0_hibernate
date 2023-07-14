package com.company.rentCar.router;

import com.company.rentCar.handler.CustomerHandler;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.Router;
import io.vertx.mutiny.ext.web.handler.BodyHandler;
import io.vertx.mutiny.ext.web.handler.LoggerHandler;

import static com.company.rentCar.Constrant.ConstrantQuery.APPLICATION_JSON;


/**
 * The type Customer router.
 */
public class CustomerRouter implements AbstractRouter{
  private final CustomerHandler handler;
  private final Vertx vertx;

  /**
   * Instantiates a new Customer router.
   *
   * @param handler the handler
   * @param vertx   the vertx
   */
  public CustomerRouter(CustomerHandler handler, Vertx vertx) {
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
    router.route("/customer").handler(LoggerHandler.create());
    router.get("/customer").respond(handler::readAll);
    router.get("/customer/:id").respond(handler::readOne);
    router.post("/customer").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::create
    );
    router.put("/customer/:id").consumes(APPLICATION_JSON).handler(BodyHandler.create()).respond(
      handler::update
    );
    router.delete("/customer/:id").respond(
      handler::delete
    );
    return router;
  }
}
