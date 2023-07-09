package com.company.rentCar.router;

import com.company.rentCar.handler.CustomerHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class CustomerRouter {
  private final CustomerHandler handler;
  private final Vertx vertx;

  public CustomerRouter(CustomerHandler handler, Vertx vertx) {
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
