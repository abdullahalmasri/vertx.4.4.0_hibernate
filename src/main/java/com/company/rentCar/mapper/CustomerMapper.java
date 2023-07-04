package com.company.rentCar.mapper;

import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

  @Mapping(target="customerId",source="entity.customerId")
  @Mapping(target="customerName",source="entity.customerName")
  @Mapping(target="customerEmail",source="entity.customerEmail")
  @Mapping(target="customerPhone",source="entity.customerPhone")
  @Mapping(target="customerDriverLicense",source="entity.customerDriverLicense")
  @Mapping(target="customerBirth",source="entity.customerBirth")
  CustomerDTO customerToCustomerDTO(Customer entity);

  @Mapping(target="customerId",source="dto.customerId")
  @Mapping(target="customerName",source="dto.customerName")
  @Mapping(target="customerEmail",source="dto.customerEmail")
  @Mapping(target="customerPhone",source="dto.customerPhone")
  @Mapping(target="customerDriverLicense",source="dto.customerDriverLicense")
  @Mapping(target="customerBirth",source="dto.customerBirth")
  Customer customerDTOToCustomer(CustomerDTO dto);
}
