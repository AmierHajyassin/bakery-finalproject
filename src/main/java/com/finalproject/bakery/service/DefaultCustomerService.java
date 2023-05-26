package com.finalproject.bakery.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.bakery.dao.CustomerDao;
import com.finalproject.bakery.entity.Customer;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultCustomerService implements CustomerService {

  @Autowired 
  private CustomerDao customerDao;


  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchCustomer() {

    return customerDao.fetchCustomer();
  }


  public Optional<Customer> createCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email) {

    log.info(
        "The createCustomer method is called with customer_namePK = {}, customer_phoneNum = {}, customer_email = {}",
        customer_namePK, customer_phoneNum, customer_email);

    return customerDao.createCustomer(customer_namePK, customer_phoneNum, customer_email);
  }


  public Optional<Customer> updateCustomer(String customer_namePK, String customer_phoneNum,
      String customer_email, String newcustomer_name, String newcustomer_phoneNum,
      String newcustomer_email) {

    log.info(
        "The updateCustomer method is called with customer_namePK = {}, customer_phoneNum = {}, customer_email = {},"
            + "newcustomer_name = {}, newcustomer_phoneNum = {}, newcustomer_email = {}",
        customer_namePK, customer_phoneNum, customer_email, newcustomer_name, newcustomer_phoneNum,
        newcustomer_email);

    return customerDao.updateCustomer(customer_namePK, customer_phoneNum, customer_email,
        newcustomer_name, newcustomer_phoneNum, newcustomer_email);
  }
}
