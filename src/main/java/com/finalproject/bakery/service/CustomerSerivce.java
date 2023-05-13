package com.finalproject.bakery.service;

import java.util.List;
import com.finalproject.bakery.entity.Customer;

public interface CustomerSerivce {

  
  List<Customer> fetchCustomer(String customer_namePK, 
              String phone_Num, String customer_email);
  
}
