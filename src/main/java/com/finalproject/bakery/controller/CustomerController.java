package com.finalproject.bakery.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/Customer")
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
      })
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchCustomer();
  
  
  @Operation(
      summary = "Create a customer",
      description = "Creating a customer using the required parameters ",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A customer is created ",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create customer with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
          
      }
      
    )
  
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Optional<Customer> createCustomer(
        @RequestParam(required = false)
        String customer_namePK,
        @RequestParam(required = false)
        String customer_phoneNum,
        @RequestParam(required = false)
        String customer_email
        );
  
  
  @Operation(
      summary = "Updating customer",
      description = "Update a customer using the requried parameters ",
      responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A customer has been updated",
             content = @Content(
                 mediaType = "application/json",
             schema = @Schema(implementation = Customer.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error has occurred",
             content = @Content(
                 mediaType = "application/json"))
      })
      
      @PutMapping
      @ResponseStatus(code = HttpStatus.OK)
      Optional<Customer> updateCustomer(
          @RequestParam(required = false)
          String customer_namePK,
          @RequestParam(required = false)
          String customer_phoneNum,
          @RequestParam(required = false)
          String customer_email,
          @RequestParam(required = false)
          String newcusotmer_name,
          @RequestParam(required = false)
          String newcustomer_phoneNum,
          @RequestParam(required = false)
          String newcustomer_email);
    
}
