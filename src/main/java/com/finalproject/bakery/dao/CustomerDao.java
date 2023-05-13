package com.finalproject.bakery.dao;

import java.util.List;
import java.util.Optional;
import com.finalproject.bakery.entity.Customer;

public interface CustomerDao {
 
//  CREATE TABLE customer(
//      customer_name VARCHAR(128) NOT NULL,
//      customer_phoneNum VARCHAR(10) NOT NULL,
//      customer_email VARCHAR(128) NOT NULL,
//      PRIMARY KEY (customer_name)
//  );
//  
     
  
  
    List<Customer> fetchCustomer(String custmoer_namePK, String customer_phoneNum, String customer_email);
    
    
    
    Optional<Customer> createCustomer(String customerName,
          String customer_phoneNum,  String customer_email);

  
  
    
    
    
    
    
    
  
}

