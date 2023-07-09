package com.company.rentCar.router;

import com.company.rentCar.handler.CarHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class CarRouter {
  private final CarHandler handler;
  private final Vertx vertx;

  public CarRouter(CarHandler handler, Vertx vertx) {
    this.handler = handler;
    this.vertx = vertx;
  }

  public void setRouter(Router router) {
    router.mountSubRouter("/", buildBookRouter());
  }

  private Router buildBookRouter() {
    final Router router = Router.router(vertx);
    return router;
  }
}
