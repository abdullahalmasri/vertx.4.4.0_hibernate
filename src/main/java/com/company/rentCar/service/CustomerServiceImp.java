package com.company.rentCar.service;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.mapper.CustomerMapper;
import com.company.rentCar.sql.CustomerRepository;
import io.vertx.core.Future;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImp implements CustomerService{

  private final CustomerRepository repository;

  public CustomerServiceImp(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Future<List<CustomerDTO>> findCustomers() {
    List<CustomerDTO> customers = new ArrayList<>();
    repository.findAllCustomer().result().forEach(customer ->
      customers.add(Mappers.getMapper(CustomerMapper.class).customerToCustomerDTO(customer))
    );
    return Future.succeededFuture(customers);
  }

  @Override
  public Future<CustomerDTO> findCustomerById(UUID customerId) {
    CustomerDTO dto = Mappers.getMapper(CustomerMapper.class).
      customerToCustomerDTO(repository.findCustomerById(
      customerId).result());
    return Future.succeededFuture(dto);
  }

  @Override
  public Future<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
    repository.saveCustomer(Mappers.getMapper(CustomerMapper.class).customerDTOToCustomer(customerDTO));
    return Future.succeededFuture(customerDTO);
  }

  @Override
  public Future<CustomerDTO> updateCustomer(CustomerDTO customerDTO) {
    repository.updateCustomer(Mappers.getMapper(CustomerMapper.class).customerDTOToCustomer(customerDTO));
    return Future.succeededFuture(customerDTO);
  }

  @Override
  public Future<Void> deleteCustomer(UUID customerId) {
    repository.deleteCustomer(customerId);
    return Future.succeededFuture();
  }
}
