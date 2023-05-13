package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.bakery.entity.Customer;


@RestController 
public class BasicCustomerController implements CustomerController {

  @Override
  public List<Customer> fetchCustomer() {
    
    return null;
  }

}
