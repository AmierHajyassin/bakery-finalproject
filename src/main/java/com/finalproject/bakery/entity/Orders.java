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
  
  private Long orderPK;
  private String customer_name; 
  private Long bakedGoodsId;
  private Quantity quantity;

}