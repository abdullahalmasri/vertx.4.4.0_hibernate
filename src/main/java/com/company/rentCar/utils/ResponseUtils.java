package com.company.rentCar.utils;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.NoSuchElementException;

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

  public static void buildErrorResponse(RoutingContext rc,Throwable throwable) {
    final int status;
    final String message;

    if (throwable instanceof IllegalArgumentException || throwable instanceof IllegalStateException || throwable instanceof NullPointerException) {
      // Bad Request
      status = 400;
      message = throwable.getMessage();
    } else if (throwable instanceof NoSuchElementException) {
      // Not Found
      status = 404;
      message = throwable.getMessage();
    } else {
      // Internal Server Error
      status = 500;
      message = "Internal Server Error";
    }

    rc.response()
      .setStatusCode(status)
      .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
      .end(new JsonObject().put("error", message).encodePrettily());
  }

  /**
   * Build success response using 201 Created as its status code and response as its body
   *
   * @param rc       Routing context
   * @param response Response body
   */
  public static void buildCreatedResponse(RoutingContext rc,
                                          Object response) {
    rc.response()
      .setStatusCode(201)
      .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
      .end(Json.encodePrettily(response));
  }

}
