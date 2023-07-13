package com.company.rentCar.service;

import com.company.rentCar.data.CustomerDTO;
import io.smallrye.mutiny.Uni;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

/**
 * The interface Customer service.
 */
public interface CustomerService {

  /**
   * Find customers uni.
   *
   * @return the uni
   */
  Uni<List<CustomerDTO>> findCustomers();

  /**
   * Find customer by id uni.
   *
   * @param customerId the customer id
   * @return the uni
   */
  Uni<CustomerDTO> findCustomerById(UUID customerId);

  /**
   * Save customer uni.
   *
   * @param customerDTO the customer dto
   * @return the uni
   */
  Uni<Void> saveCustomer(CustomerDTO customerDTO);

  /**
   * Update customer uni.
   *
   * @param customerDTO the customer dto
   * @return the uni
   */
  Uni<Integer> updateCustomer(CustomerDTO customerDTO);

  /**
   * Delete customer uni.
   *
   * @param customerId the customer id
   * @return the uni
   */
  Uni<Integer> deleteCustomer(UUID customerId);
}
