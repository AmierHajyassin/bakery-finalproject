package com.finalproject.bakery.entity;

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
  private String customer_name; 
  private BakedGoods bakedGoods;
  private Quantity quantity;

}