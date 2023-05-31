package com.finalproject.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.finalproject.bakery.entity.BakedGoods;
import com.finalproject.bakery.entity.BakedGoodsEntity;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBakedGoodsEntityDao implements BakedGoodsEntityDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<BakedGoodsEntity> fetchBakedGoodsEntity() {
    log.info("DAO: fetch Baked Goods ");
    //@formatter:off
    
        String sql= ""
            +"SELECT * "
            +" FROM baked_goods ";
       //@formatter:on
    return jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public BakedGoodsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
          return BakedGoodsEntity
              .builder()
              .bakedGoodsId(rs.getLong("baked_goods_id"))
              .bakedGoods(BakedGoods.valueOf(rs.getString("baked_goods")))
              .build();
      }
    });
  }
}