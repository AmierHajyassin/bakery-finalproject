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
public class Orders {
  
  private long orderPK;
  private BigDecimal orderTotal;
  private String customer_name; 
  private Long bakedGoods;

}
