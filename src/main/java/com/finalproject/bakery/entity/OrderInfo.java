package com.finalproject.bakery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class OrderInfo {
  
  private Long bakedGoodsId;
  private Long orderPK;// orderPK == order_number in sql file
  private OrderStatus orderStatus; 
  
}
