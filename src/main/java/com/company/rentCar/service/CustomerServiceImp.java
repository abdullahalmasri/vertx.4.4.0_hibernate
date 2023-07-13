package com.company.rentCar.service;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.mapper.CustomerMapper;
import com.company.rentCar.sql.CustomerRepository;
import io.smallrye.mutiny.Uni;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Customer service imp.
 */
public class CustomerServiceImp implements CustomerService, Serializable {

  private static final long serialVersionUID = 77L;

  private final CustomerRepository repository;

  /**
   * Instantiates a new Customer service imp.
   *
   * @param repository the repository
   */
  public CustomerServiceImp(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Uni<List<CustomerDTO>> findCustomers() {
    Uni<List<CustomerDTO>> result = repository.findAllCustomer()
      .onItem()
      .transform(customers -> customers
        .stream()
        .map(customer ->
          Mappers.getMapper(CustomerMapper.class).customerToCustomerDTO(customer)
        )
        .collect(Collectors.toList())
      );
    return result;
  }

  @Override
  public Uni<CustomerDTO> findCustomerById(UUID customerId) {
    Uni<CustomerDTO> dto = repository.findCustomerById(customerId)
      .onItem()
      .ifNotNull()
      .transform(customer ->
        Mappers.getMapper(CustomerMapper.class).customerToCustomerDTO(customer)
      );
    return dto;
  }

  @Override
  public Uni<Void> saveCustomer(CustomerDTO customerDTO) {
    if (customerDTO.getCustomerId() == null) {
      customerDTO.setCustomerId(UUID.randomUUID());
    }
    return repository.saveCustomer(Mappers.getMapper(CustomerMapper.class).customerDTOToCustomer(customerDTO));
  }

  @Override
  public Uni<Integer> updateCustomer(CustomerDTO customerDTO) {
    if (customerDTO.getCustomerId() == null) {
      return null;
    }
    Uni<Integer> success = repository.updateCustomer(Mappers.getMapper(CustomerMapper.class).customerDTOToCustomer(customerDTO));
    return success;
  }

  @Override
  public Uni<Integer> deleteCustomer(UUID customerId) {
    return repository.deleteCustomer(customerId);
  }
}
