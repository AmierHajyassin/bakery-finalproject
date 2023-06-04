package com.finalproject.bakery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.bakery.dao.OrdersDao;
import com.finalproject.bakery.entity.Orders;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOrdersService implements OrdersService {
  
  @Autowired
   private OrdersDao ordersDao;

    @Transactional(readOnly = true)
    @Override
    public List<Orders> fetchOrders() {
      return ordersDao.fetchOrders();
  }

}
