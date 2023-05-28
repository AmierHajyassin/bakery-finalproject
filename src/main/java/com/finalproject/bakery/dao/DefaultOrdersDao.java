package com.finalproject.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.finalproject.bakery.entity.BakedGoods;
import com.finalproject.bakery.entity.Orders;
import com.finalproject.bakery.entity.Quantity;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOrdersDao implements OrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Orders> fetchOrders() {
    log.info("DAO: fetch Orders ");
    //@formatter:off
    String sql = ""
        +"SELECT * "
        +"FROM orders ";
    //@formatter:on
    return jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Orders.builder().orderPK(rs.getLong("order_number"))
            .customer_name(rs.getString("customer_name"))
            .bakedGoods(BakedGoods.valueOf(rs.getString("baked_goods")))
            .quantity(Quantity.valueOf(rs.getString("quantity")))
            .build();
      }
    });
  }

}
