package com.finalproject.bakery.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.bakery.entity.Customer;
import com.finalproject.bakery.service.CustomerService;
import lombok.extern.slf4j.Slf4j;


@RestController 
@Slf4j 

public class DefaultCustomerController implements CustomerController {

  @Autowired
  private CustomerService customerService;
 

  public List<Customer> fetchCustomer(){
    
    return customerService.fetchCustomer();
}
  
  @Override
  public Optional<Customer> createCustomer(String customer_namePK, 
        String customer_phoneNum, String customer_email){
  log.info("cusotmer_namePK = {}, customer_phoneNum = {}, customer_email = {}", customer_namePK, 
      customer_phoneNum,  customer_email);
  
  return customerService.createCustomer(customer_namePK, customer_phoneNum, customer_email);
  }
  
  @Override
   public Optional<Customer> updateCustomer(String customer_namePK, String customer_phoneNum, String customer_email,
      String newcustomer_name, String newcustomer_phoneNum, String newcustomer_email ){

log.info("customer_namePK = {}, customer_phoneNum = {}, customer_email = {},"
    + "newcustomer_name = {}, newcustomer_phoneNum = {}, newcustomer_email = {}", customer_namePK, customer_phoneNum, customer_email,
    newcustomer_name, newcustomer_phoneNum, newcustomer_email );

      return customerService.updateCustomer(customer_namePK, customer_phoneNum, customer_email,
          newcustomer_name, newcustomer_phoneNum, newcustomer_email);
  }
  
  
  


  
  
}