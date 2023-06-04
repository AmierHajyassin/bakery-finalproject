package com.finalproject.bakery.dao;

import java.util.List;
import com.finalproject.bakery.entity.Orders;


public interface OrdersDao {

  List<Orders> fetchOrders();

}
