package com.company.rentCar.sql;

import com.company.rentCar.model.Customer;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository {
  /**
   * Find all customer uni.
   *
   * @return the uni
   */
  Uni<List<Customer>> findAllCustomer();

  /**
   * Find customer by id uni.
   *
   * @param customerId the customer id
   * @return the uni
   */
  Uni<Customer> findCustomerById(UUID customerId);

  /**
   * Save customer uni.
   *
   * @param customer the customer
   * @return the uni
   */
  Uni<Void> saveCustomer(Customer customer);

  /**
   * Update customer uni.
   *
   * @param customer the customer
   * @return the uni
   */
  Uni<Integer> updateCustomer(Customer customer);

  /**
   * Delete customer uni.
   *
   * @param customerId the customer id
   * @return the uni
   */
  Uni<Integer> deleteCustomer(UUID customerId);

}
