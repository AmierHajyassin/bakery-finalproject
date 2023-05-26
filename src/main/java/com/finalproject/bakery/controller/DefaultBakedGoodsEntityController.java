package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.bakery.entity.BakedGoodsEntity;
import com.finalproject.bakery.service.BakedGoodsEntityService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBakedGoodsEntityController implements BakedGoodsEntityController {

  @Autowired
  private BakedGoodsEntityService bakedGoodsEntityService;

  public List<BakedGoodsEntity> fetchBakedGoodsEntity() {

    return bakedGoodsEntityService.fetchBakedGoodsEntity();

  }




}


