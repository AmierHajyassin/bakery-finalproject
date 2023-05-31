package com.finalproject.bakery.dao;

import java.util.List;
import com.finalproject.bakery.entity.OrderInfo;

public interface OrderInfoDao {

  List<OrderInfo>fetchOrderInfo();
  
}

