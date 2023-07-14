/*
this is where we implement the Facade Design Pattern for making maintenance easier

 */

package com.company.rentCar.router;

import com.company.rentCar.handler.BookingHandler;
import com.company.rentCar.handler.CarHandler;
import com.company.rentCar.handler.CustomerHandler;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.Router;

public class MainRouter {

  private AbstractRouter BookingRouter;
  private AbstractRouter CarRouter;
  private AbstractRouter CustomerRouter;
  private final Vertx vertx;
  private final BookingHandler bh;
  private final CustomerHandler ch;
  private final CarHandler cch;
  private final Router router;

  public MainRouter(Router router, Vertx vertx, BookingHandler bh, CustomerHandler ch, CarHandler cch) {
    this.router = router;
    this.BookingRouter = new BookingRouter(bh, vertx);
    this.CarRouter = new CarRouter(cch, vertx);
    this.CustomerRouter = new CustomerRouter(ch, vertx);
    this.vertx = vertx;
    this.bh = bh;
    this.ch = ch;
    this.cch = cch;
  }

  public void setBookingRouter() {
    BookingRouter.setRouter(router);
  }

  public void setCustomerRouter() {
    CustomerRouter.setRouter(router);
  }

  public void setCarRouter() {
    CarRouter.setRouter(router);
  }
}
