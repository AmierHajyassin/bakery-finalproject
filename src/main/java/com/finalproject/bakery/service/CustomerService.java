package com.finalproject.bakery.service;

import java.util.List;
import java.util.Optional;
import com.finalproject.bakery.entity.Customer;

public interface CustomerService {

  
  List<Customer> fetchCustomer();

  Optional<Customer> createCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email);

  Optional<Customer> updateCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email, String newcustomer_name, String newcustomer_phoneNum,
      String newcustomer_email);

}
