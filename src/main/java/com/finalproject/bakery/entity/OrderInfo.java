package com.finalproject.bakery.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class OrderInfo {
  
  private Long orderPK;// orderPK == order_number in sql file
  private Long bakedGoodsId;
  private BigDecimal total;
  private OrderStatus orderStatus; 
  
}
