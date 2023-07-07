package com.company.rentCar.sql;

import com.company.rentCar.model.Customer;
import io.vertx.core.Future;
import org.hibernate.reactive.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.company.rentCar.Constrant.ConstrantQuery.DELETE_CUSTOMER;
import static com.company.rentCar.Constrant.ConstrantQuery.SELECT_ALL_CUSTOMER;

public class CustomerRepositoryImp implements CustomerRepository {



  private final Stage.SessionFactory factory;

  public CustomerRepositoryImp(Stage.SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public Future<List<Customer>> findAllCustomer() {
    try {
      List<Customer> customers = new ArrayList<>();
      factory.withSession(
        session -> session.createQuery(SELECT_ALL_CUSTOMER,Customer.class)
        .getResultList().thenAccept(customers::addAll)
      ).toCompletableFuture().join();
      return Future.succeededFuture(customers);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    } finally {
      factory.close();

    }
  }

  @Override
  public Future<Customer> findCustomerById(UUID customerId) {
    try {
      Customer customer=factory.withSession(
        session -> session.find(Customer.class, customerId))
        .toCompletableFuture().join();
      return Future.succeededFuture(customer);
    }catch(Exception e) {
      System.out.println(e.getMessage());
      return Future.failedFuture(e);
    }finally {
      factory.close();
    }

  }

  @Override
  public Future<Customer> saveCustomer(Customer customer) {

    try {
      factory.withTransaction((session, transaction) ->
        session.persist(Customer.class, customer)).toCompletableFuture().join();
      return Future.succeededFuture(customer);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Customer> updateCustomer(Customer customer) {

    try {
      factory.withTransaction((session, transaction) ->
        session.createQuery("update Customer c set c.customerName=" +customer.getCustomerName()+
          ",c.customerEmail=" +customer.getCustomerEmail()+
          ",c.customerPhone=" + customer.getCustomerPhone()+
          ",c.customerDriverLicense=" +customer.getCustomerDriverLicense()+
          ",c.customerBirth= " +customer.getCustomerBirth()+
          " where c.customerId='"+customer.getCustomerId()+"'")
        .executeUpdate()
      ).toCompletableFuture().join();
      return Future.succeededFuture(customer);
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }

  @Override
  public Future<Void> deleteCustomer(UUID customerId) {

    try {
      int deleted = factory.withTransaction((session, transaction) -> session.createQuery(DELETE_CUSTOMER)
        .executeUpdate()).toCompletableFuture().join();
      if (deleted == 1) {
        System.out.println("deleted customer");
      }
      return Future.succeededFuture();
    } catch (Exception e) {
      e.printStackTrace();
      return Future.failedFuture(e);
    } finally {
      factory.close();
    }
  }
}
