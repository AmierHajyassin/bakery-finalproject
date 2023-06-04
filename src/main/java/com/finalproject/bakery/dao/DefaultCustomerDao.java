package com.finalproject.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.finalproject.bakery.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Customer> fetchCustomer() {

    log.info("DAO: fetch customers");
    // formatter:off
    String sql = "" + " SELECT * FROM  customer";
    // formatter:off
    return jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // formatter:off
        return Customer.builder()
            .customer_name(rs.getString("customer_name"))
            .customer_phoneNum(rs.getString("customer_phoneNum"))
            .customer_email(rs.getString("customer_email")).build();
        // formatter:on
      }
    });

  }

  // @Override
  // method to create new customer with customers table
  public Optional<Customer> createCustomer(String customer_name, String customer_phoneNum,
      String customer_email) {

    log.info("DAO: customer_name= {}, customer_phoneNum= {}, customer_email= {} ", customer_name,
        customer_phoneNum, customer_email);

    // formatter:off

    String sql = "" 
        + "INSERT INTO customer(" 
        + "customer_name, customer_phoneNum, customer_email"
        + ") VALUES(" 
        + ":customer_name, :customer_phoneNum, :customer_email)";

    Map<String, Object> params = new HashMap<>();
    params.put("customer_name", customer_name);
    params.put("customer_phoneNum", customer_phoneNum);
    params.put("customer_email", customer_email);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customer.builder()
        .customer_name(customer_name)
        .customer_phoneNum(customer_phoneNum)
        .customer_email(customer_email)
        .build());
    // formatter:on
  }

  // method to update customer info
  public Optional<Customer> updateCustomer(String customer_name, String customer_phoneNum,
      String customer_email, String newcustomer_name, String newcustomer_phoneNum,
      String newcustomer_email) {

    log.info("DAO: customer_name= {}, customer_phoneNum= {}, customer_emai = {}, "
            + "newcustomer_name= {}, newcustomer_phoneNum= {}, newcustomer_email= {}",
        customer_name, customer_phoneNum, customer_email, newcustomer_name, newcustomer_phoneNum,
        newcustomer_email);

    //@formatter:off
    String sql = ""
        + "UPDATE customer SET customer_name = :newcustomer_name, "
        + "customer_phoneNum = :newcustomer_phoneNum, "
        + "customer_email = :newcustomer_email "
        + "WHERE customer_name = :customer_name AND "
        + "customer_phoneNum = :customer_phoneNum AND "
        + "customer_email = :customer_email";
    
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("customer_name", customer_name);
    params.put("customer_phoneNum", customer_phoneNum);
    params.put("customer_email", customer_email);
    params.put("newcustomer_name", newcustomer_name);
    params.put("newcustomer_phoneNum", newcustomer_phoneNum);
    params.put("newcustomer_email", newcustomer_email);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customer.builder()
        .customer_name(newcustomer_name)
        .customer_phoneNum(newcustomer_phoneNum)
        .customer_email(newcustomer_email)
        .build());

  }

  // method to delete customer
  @Override
  public Optional<Customer> deleteCustomer(String customer_name, String customer_phoneNum, String customer_email) {    
    //@formatter:off
    String sql= ""
        +"DELETE FROM customer "
        + "WHERE customer_name = :customer_name AND "
        + "customer_phoneNum = :customer_phoneNum AND "
        + "customer_email = :customer_email";
        //@formatter:on

    log.info(sql);
    Map<String, Object> params = new HashMap<>();
    params.put("customer_name", customer_name);
    params.put("customer_phoneNum", customer_phoneNum);
    params.put("customer_email", customer_email);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customer.builder()
        .customer_name(customer_name)
        .customer_phoneNum(customer_phoneNum)
        .customer_email(customer_email)
        .build());
  }

}
