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

  private String customer_namePK;
  private String phone_Num;
  private String customer_email;
  
  
}
