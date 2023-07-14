// we need it ot build Facade Design Pattern

package com.company.rentCar.router;

import io.vertx.mutiny.ext.web.Router;

public interface AbstractRouter {
  
   void setRouter(Router router);
}
