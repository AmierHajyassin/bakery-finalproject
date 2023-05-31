package com.finalproject.bakery.service;

import java.util.List;
import com.finalproject.bakery.entity.Orders;

public interface OrdersService {

  List<Orders> fetchOrders();

}
