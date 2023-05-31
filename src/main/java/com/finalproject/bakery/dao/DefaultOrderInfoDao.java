package com.finalproject.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.finalproject.bakery.entity.OrderInfo;
import com.finalproject.bakery.entity.OrderStatus;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOrderInfoDao implements OrderInfoDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<OrderInfo> fetchOrderInfo() {
    log.info("DAO: fetch Order Information");
    //@formatter:off
    
    String sql = ""
        +"SELECT * "
        +"FROM order_info ";
    //@formatter:on
    return jdbcTemplate.query(sql, new RowMapper<>() {
      public OrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrderInfo.builder()
            .orderPK(rs.getLong("order_number"))
            .bakedGoodsId(rs.getLong("baked_goods_id"))
            .orderStatus(OrderStatus.valueOf(rs.getString("order_status")))
            .total(rs.getBigDecimal("total"))
            .build();
      }
    });
  }
}