package com.company.rentCar.utils;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class ResponseUtils {
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String APPLICATION_JSON = "application/json";

  private ResponseUtils() {

  }

  /**
   * Build success response using 200 OK as its status code and response as its body
   *
   * @param rc       Routing context
   * @param response Response body
   */
  public static void buildOkResponse(RoutingContext rc,
                                     Object response) {
    rc.response()
      .setStatusCode(200)
      .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
      .end(Json.encodePrettily(response));
  }
}
