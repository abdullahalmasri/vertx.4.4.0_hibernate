package com.company.rentCar.mapper;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Customer mapper.
 */
@Mapper
public interface CustomerMapper {

  /**
   * Customer to customer dto customer dto.
   *
   * @param entity the entity
   * @return the customer dto
   */
  @Mapping(target = "customerId", source = "entity.customerId")
  @Mapping(target = "customerName", source = "entity.customerName")
  @Mapping(target = "customerEmail", source = "entity.customerEmail")
  @Mapping(target = "customerPhone", source = "entity.customerPhone")
  @Mapping(target = "customerDriverLicense", source = "entity.customerDriverLicense")
  @Mapping(target = "customerBirth", source = "entity.customerBirth")
  CustomerDTO customerToCustomerDTO(Customer entity);

  /**
   * Customer dto to customer customer.
   *
   * @param dto the dto
   * @return the customer
   */
  @Mapping(target = "customerId", source = "dto.customerId")
  @Mapping(target = "customerName", source = "dto.customerName")
  @Mapping(target = "customerEmail", source = "dto.customerEmail")
  @Mapping(target = "customerPhone", source = "dto.customerPhone")
  @Mapping(target = "customerDriverLicense", source = "dto.customerDriverLicense")
  @Mapping(target = "customerBirth", source = "dto.customerBirth")
  Customer customerDTOToCustomer(CustomerDTO dto);
}
