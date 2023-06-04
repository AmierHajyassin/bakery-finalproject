package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.bakery.entity.Orders;
import com.finalproject.bakery.service.OrdersService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultOrdersController implements OrdersController {
   
  @Autowired 
  private OrdersService ordersService;
  
 public List<Orders> fetchOrders(){
    return ordersService.fetchOrders();
 }

}
