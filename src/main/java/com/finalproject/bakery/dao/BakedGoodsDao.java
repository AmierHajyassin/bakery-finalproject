package com.finalproject.bakery.dao;

import java.util.List;
import com.finalproject.bakery.entity.BakedGoods;


public interface BakedGoodsDao {

  
  List<BakedGoods> fetchBakedGoods(String bakedGoodsId, BakedGoods bakedGoods);
  
  
  
}
