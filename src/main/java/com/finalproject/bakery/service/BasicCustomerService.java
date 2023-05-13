package com.finalproject.bakery.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.bakery.dao.CustomerDao;
import com.finalproject.bakery.entity.Customer;
import lombok.extern.slf4j.Slf4j;




//CREATE TABLE customer(
//    customer_name VARCHAR(128) NOT NULL,
//    customer_phoneNum VARCHAR(10) NOT NULL,
//    customer_email VARCHAR(128) NOT NULL,
//    PRIMARY KEY (customer_name)
//);




@Service
@Slf4j
public class BasicCustomerService implements CustomerService{
  
  @Autowired
  public CustomerDao customerDao;
  
  
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email) {
    log.info("The fetchCustomer method is called with customer_namePK ={}, customer_phoneNum ={}, customer_email = {}",
        customer_namePK, customer_phoneNum, customer_email);
    return customerDao.createCustomer(customer_name, customer_phoneNum, customer_email);
  }
  
  
  @Override 
  public Optional<Customer> createCustomer(String customer_namePK, customer_phoneNum, customer_email){
    log.info("The createCustomer method is called with customer_namePK ={}, customer_phoneNum ={},customer_email = {} "
          , customer_namePK, customer_phoneNum, customer_email);
    return customerDao.createCustomers(customer_name, customer_phoneNum, customer_email);
    
  }

}
