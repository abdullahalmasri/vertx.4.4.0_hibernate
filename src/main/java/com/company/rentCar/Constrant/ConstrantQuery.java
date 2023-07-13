package com.company.rentCar.Constrant;

public class ConstrantQuery {

  //handler Constrants
  public static final String ID_PARAMETER = "id";


  // Sql Statements for Booking table

  public static final String SELECT_ALL_BOOKING = "select d from Booking d";
  public static final String DELETE_BOOKING = "delete Booking AS d where d.bookingId='";




  // Sql Statements for Customer table

  public static final String SELECT_ALL_CUSTOMER = "SELECT c from Customer c";
  public static final String DELETE_CUSTOMER = "delete Customer AS c where c.customerId='";


  // Sql Statements for Car table

  public static final String SELECT_ALL_CAR = "SELECT cc from Car cc";
  public static final String DELETE_CAR = "delete Car AS cc where cc.carId='";

  public static final String APPLICATION_JSON = "application/json";


}
