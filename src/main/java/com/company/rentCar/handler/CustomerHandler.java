package com.company.rentCar.handler;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.service.CustomerService;
import com.company.rentCar.utils.ResponseUtils;
import io.vertx.core.Future;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

public class CustomerHandler {

  private final CustomerService service;

  public CustomerHandler(CustomerService service) {
    this.service = service;
  }

  public Future<List<CustomerDTO>> readAll(RoutingContext rc) {
    List<CustomerDTO> bookingList = new ArrayList<>();
    return service.findCustomers()
      .onSuccess(success ->{
        bookingList.addAll(success);
        ResponseUtils.buildOkResponse(rc, success);
      } );
  }

  public Future<CustomerDTO> readOne(RoutingContext rc) {
    return service.findCustomerById(UUID.fromString(getId(rc)))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<CustomerDTO> create(RoutingContext rc) {

    return service.saveCustomer(rc.body().asJsonObject().mapTo(CustomerDTO.class))
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<CustomerDTO> update(RoutingContext rc) {
    UUID customerId = UUID.fromString(getId(rc));
    CustomerDTO dto = rc.body().asJsonObject().mapTo(CustomerDTO.class);
    dto.setCustomerId(customerId);
    return service.updateCustomer(dto)
      .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
      .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }

  public Future<Void> delete(RoutingContext rc) {
    return
      service.deleteCustomer(UUID.fromString(getId(rc)))
        .onSuccess(success -> ResponseUtils.buildOkResponse(rc, success))
        .onFailure(failure -> ResponseUtils.buildErrorResponse(rc, failure));
  }


  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
