package com.finalproject.bakery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BakedGoodsEntity {
  
  private Long bakedGoodsId;
  private BakedGoods bakedgoods;

 
}
