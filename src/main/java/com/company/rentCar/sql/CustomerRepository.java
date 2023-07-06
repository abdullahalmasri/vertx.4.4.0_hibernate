package com.company.rentCar.sql;

import com.company.rentCar.model.Customer;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
  Future<List<Customer>> findAllCustomer();

  Future<Customer> findCustomerById(UUID customerId);

  Future<Customer> saveCustomer(Customer customer);

  Future<Customer> updateCustomer(Customer customer);

  Future<Void> deleteCustomer(UUID customerId);

}
