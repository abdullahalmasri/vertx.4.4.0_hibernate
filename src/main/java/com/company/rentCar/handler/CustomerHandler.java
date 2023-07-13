package com.company.rentCar.handler;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.service.CustomerService;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.ext.web.RoutingContext;

import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.ID_PARAMETER;

/**
 * The type Customer handler.
 */
public class CustomerHandler {

  private final CustomerService service;

  /**
   * Instantiates a new Customer handler.
   *
   * @param service the service
   */
  public CustomerHandler(CustomerService service) {
    this.service = service;
  }

  /**
   * Read all uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<List<CustomerDTO>> readAll(RoutingContext rc) {
    return service.findCustomers();
  }

  /**
   * Read one uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<CustomerDTO> readOne(RoutingContext rc) {
    return service.findCustomerById(UUID.fromString(getId(rc)));
  }

  /**
   * Create uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Void> create(RoutingContext rc) {

    return service.saveCustomer(rc.body().asJsonObject().mapTo(CustomerDTO.class));
  }

  /**
   * Update uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> update(RoutingContext rc) {
    UUID customerId = UUID.fromString(getId(rc));
    CustomerDTO dto = rc.body().asJsonObject().mapTo(CustomerDTO.class);
    dto.setCustomerId(customerId);
    return service.updateCustomer(dto);
  }

  /**
   * Delete uni.
   *
   * @param rc the rc
   * @return the uni
   */
  public Uni<Integer> delete(RoutingContext rc) {
    return
      service.deleteCustomer(UUID.fromString(getId(rc)));
  }


  private String getId(RoutingContext rc) {
    String id = rc.pathParam(ID_PARAMETER);
    return id;
  }
}
