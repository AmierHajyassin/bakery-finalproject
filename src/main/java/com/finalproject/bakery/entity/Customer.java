package com.finalproject.bakery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor

public class Customer {

  private String customer_name;
  private String customer_phoneNum;
  private String customer_email;
  
  
}