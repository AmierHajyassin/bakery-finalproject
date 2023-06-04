package com.finalproject.bakery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.bakery.dao.OrderInfoDao;
import com.finalproject.bakery.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOrderInfoService implements OrderInfoService{

  @Autowired
  private OrderInfoDao orderInfoDao;

  @Transactional(readOnly = true)

  @Override
  public List<OrderInfo> fetchOrderInfo() {

    return orderInfoDao.fetchOrderInfo();
  }

 
 

}
