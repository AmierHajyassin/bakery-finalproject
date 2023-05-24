//package com.finalproject.bakery.dao;
//
//import java.util.List;
//import java.util.Map;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import com.finalproject.bakery.entity.BakedGoods;
//import com.mysql.cj.log.Log;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//
//
//
//public class DefaultBakedGoodsDao implements BakedGoodsDao {
//
//  @Autowired
//  private NamedParameterJdbcTemplate jdbcTemplate;
//
//  @Override
//  public List<BakedGoods> fetchBakedGoods(String bakedGoodsId, BakedGoods bakedGoods) {
//
//    log.info("DAO: bakedGoodsId ={}, bakedGoods ={}", bakedGoodsId, bakedGoods);
//
//   //@formatter:off
//    
//    String sql =""
//       + "SELECT * "
//       + "FROM baked_goods "
//       + "WHERE baked_goods_id = :baked_goods_id AND "
//       + "baked_goods = :baked_goods ";
//    
//    //formatter:on
//    
//    Map<String, Object> params = new HashMap<>();  
//    params.put("baked_goods_id", bakedGoodsId);
//    params.put("baked_goods", bakedGoods.toString());
//    
//    return jdbcTemplate.query(sql, params, new RowMapper<>(){
// 
//      @Override 
//      public BakedGoods mapRow(ResultSet rs, int rowNum) throws SQLException{
//      //@formatter:off
//        return BakedGoods.builder()
//            .bakedGoodsId(bakedGoodsId)
//            .bakedGoods(bakedGoods)
//            .build();
//        //formatter:on
//        }});
//   
//    
//       }
//  
////  public List<BakedGoods> createBakedGoods(String bakedGoodsId, BakedGoods bakedGoods){
////    log.info("DAO: bakedGoodsId ={}, bakedGoods ={}", bakedGoodsId, bakedGoods);
////    
////    //formatter:off
////    String sql=""
////        +"INSERT INTO baked_goods ("
////        +" Baked_goods_id, baked_goods"
////        +") VALUES ("
////        +" :baked_goods_id, :baked_goods)";
////  }
////   //formatter:on
////  
////  Map<String, Object> params = new HashMap<>();
////  params.put("baked_goods_id", bakedGoodsId);
////  params.put("baked_goods", bakedGoods);
////  
////    jdbcTemplate.update(sql, parms);
////    
////    return Optional.ofNullable
////        .BakedGoods.builder()
////        .bakedGoodsId(bakedGoodsId)
////        .bakedGoods(bakedGoods)
////        .build();
////  
////}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
