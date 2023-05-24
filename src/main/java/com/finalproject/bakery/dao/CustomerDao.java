package com.finalproject.bakery.dao;

import java.util.List;
import java.util.Optional;
import com.finalproject.bakery.entity.Customer;

public interface CustomerDao {

  // CREATE TABLE customer(
  // customer_name VARCHAR(128) NOT NULL,
  // customer_phoneNum VARCHAR(10) NOT NULL,
  // customer_email VARCHAR(128) NOT NULL,
  // PRIMARY KEY (customer_name)
  // );
  //


  // customer table
  List<Customer> fetchCustomer();
  
  // creates new customer
  Optional<Customer> createCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email);
  
  // updates customer
  Optional<Customer> updateCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email, String newcustomer_name, String newcustomer_phoneNum,
      String newcustomer_email);
  
  
//deleting customer
  Optional<Customer> deleteCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email);

}
