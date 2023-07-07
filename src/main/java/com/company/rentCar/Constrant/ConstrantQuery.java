package com.company.rentCar.Constrant;

public class ConstrantQuery {


  // Sql Statements for Booking table

  public static final String SELECT_ALL_BOOKING = "SELECT d from Booking AS d";
  public static final String DELETE_BOOKING = "delete Booking AS d where d.bookingId='";
  public static final String UPDATE_ALL_BOOKING = "update d from Booking AS set d. d where d.bookingId=";




  // Sql Statements for Customer table

  public static final String SELECT_ALL_CUSTOMER = "SELECT c from Customer AS c";
  public static final String DELETE_CUSTOMER = "delete Customer AS c where c.customerId='";


  // Sql Statements for Car table

  public static final String SELECT_ALL_CAR = "SELECT cc from Car AS cc";
  public static final String DELETE_CAR = "delete Car AS cc where cc.carId='";

}
