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
  private int customer_id; 
  private Long bakedGoodsId;
  private Quantity quantity;

}