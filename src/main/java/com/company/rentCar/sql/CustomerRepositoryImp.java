package com.company.rentCar.sql;

import com.company.rentCar.model.Customer;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.DELETE_CUSTOMER;
import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_CUSTOMER;

/**
 * The type Customer repository imp.
 */
public class CustomerRepositoryImp implements CustomerRepository, Serializable {

  private static final long serialVersionUID = 90908L;

  private final Mutiny.SessionFactory factory;

  /**
   * Instantiates a new Customer repository imp.
   *
   * @param factory the factory
   */
  public CustomerRepositoryImp(Mutiny.SessionFactory factory) {
    this.factory = Persistence
      .createEntityManagerFactory("postgresql-example")
      .unwrap(Mutiny.SessionFactory.class);
  }

  @Override
  public Uni<List<Customer>> findAllCustomer() {
    try {
      return
        factory.withSession(
          session -> session.createQuery(SELECT_ALL_CUSTOMER, Customer.class)
            .getResultList())
          .onItem()
          .ifNotNull()
          .transform(customers -> customers);
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Customer> findCustomerById(UUID customerId) {
    try {
      return factory.withSession(
        session -> session.find(Customer.class, customerId))
        .onItem().ifNull().continueWith(Customer::new);
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }

  }

  @Override
  public Uni<Void> saveCustomer(Customer customer) {

    try {
      return factory.withTransaction((session, transaction) ->
        session.persist(customer));
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Integer> updateCustomer(Customer customer) {

    try {
      return factory.withTransaction((session, transaction) ->
        session.createQuery("update Customer c set c.customerName=" + customer.getCustomerName() +
          ",c.customerEmail=" + customer.getCustomerEmail() +
          ",c.customerPhone=" + customer.getCustomerPhone() +
          ",c.customerDriverLicense=" + customer.getCustomerDriverLicense() +
          ",c.customerBirth= " + customer.getCustomerBirth() +
          " where c.customerId='" + customer.getCustomerId() + "'")
          .executeUpdate()
      );
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }

  @Override
  public Uni<Integer> deleteCustomer(UUID customerId) {

    try {
      return factory.withTransaction((session, transaction) ->
        session.createQuery(DELETE_CUSTOMER + customerId + "'")
          .executeUpdate());
    } catch (Exception e) {
      return Uni.createFrom().failure(e);
    }
  }
}
