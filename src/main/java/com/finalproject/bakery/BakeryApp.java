package com.finalproject.bakery;

import org.springframework.boot.SpringApplication;
import com.finalproject.ComponentScanMarker;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})

public class BakeryApp {
 
 
    public static void main(String[] args) {
      SpringApplication.run( BakeryApp.class, args);
    }
  }


     