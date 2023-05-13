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
public class BakedGoodsEntity {
  
  private Long bakedGoodsId;
  private BakedGoods bakedgoods;
  private Quantity quantity;
 
}
