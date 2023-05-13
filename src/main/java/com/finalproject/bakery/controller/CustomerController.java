package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.finalproject.bakery.entity.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.Parameter;

@Validated 
@RequestMapping("/Customers")
@OpenAPIDefinition(info = @Info(title = "Bakery"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface CustomerController {
  //formatter:off
  @Operation(
      summary = "Retruns a list of customers",
      description = "Returns a list of customers with a given customer id ",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Customers is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Customer.class))), //200 is an okay status
          @ApiResponse(
              responseCode = "400", 
              description = "The request paramaters are invalid",
              content = @Content(mediaType = "application/json")),//400 is a bad input
          @ApiResponse(
              responseCode = "404", 
              description = "No customers were found with the input criteria.", 
              content = @Content(mediaType = "application/json")), //404 not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))  //500 is an unplanned exception
      },
//      //
//          parameters = {
//              @Parameter(             
//                  description = "Some description goes here"),
//          } // end parameters
//      
//      
      parameters = {
          @Parameter(
              name = "Customer_name",
              allowEmptyValue = false, 
              required = false,
              description = "return a list of customers"),
          @Parameter( 
              name = "Baked Goods", 
              allowEmptyValue = false,
              required = false, 
              description = "The baked goods level (i.e 'baklava')")
          
     }
      
  )
    
      @GetMapping
      @ResponseStatus(code = HttpStatus.OK)
  
  List<Customer> fetchCustomer();
   
      
}     
