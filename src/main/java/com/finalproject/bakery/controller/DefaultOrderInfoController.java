package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.bakery.entity.OrderInfo;
import com.finalproject.bakery.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Service


public class DefaultOrderInfoController implements OrderInfoController {

  @Autowired

  private OrderInfoService orderInfoService;

  public List<OrderInfo> fetchOrderInfo() {
    return orderInfoService.fetchOrderInfo();
  }


}
