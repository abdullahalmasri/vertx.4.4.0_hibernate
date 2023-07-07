package com.company.rentCar.service;

import com.company.rentCar.data.CustomerDTO;
import io.vertx.core.Future;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

  Future<List<CustomerDTO>> findCustomers();

  Future<CustomerDTO> findCustomerById(UUID customerId);

  Future<CustomerDTO> saveCustomer(CustomerDTO customerDTO);

  Future<CustomerDTO> updateCustomer(CustomerDTO customerDTO);

  Future<Void> deleteCustomer(UUID customerId);
}
