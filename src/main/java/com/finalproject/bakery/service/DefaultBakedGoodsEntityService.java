package com.finalproject.bakery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.bakery.dao.BakedGoodsEntityDao;
import com.finalproject.bakery.entity.BakedGoodsEntity;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultBakedGoodsEntityService implements BakedGoodsEntityService {
  
  @Autowired 
  private BakedGoodsEntityDao bakedGoodsEntityDao;
    
  @Transactional(readOnly = true)
  @Override
  public List<BakedGoodsEntity> fetchBakedGoodsEntity(){
    
    return  bakedGoodsEntityDao.fetchBakedGoodsEntity();
  }
}