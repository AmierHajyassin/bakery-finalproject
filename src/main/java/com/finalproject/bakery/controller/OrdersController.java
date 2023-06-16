package com.finalproject.bakery.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.finalproject.bakery.entity.Orders;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Orders")
@OpenAPIDefinition(info = @Info(title = "Orders service"), 
    servers = {@Server(
    url = "http://localhost:8080", 
    description = "Local server")})

public interface OrdersController {
  //@formatter:off
   @Operation(
       summary = "Returns a list of Orders",
       description = "A list of Orders is return with given parameters", 
       responses = {
           @ApiResponse(
               responseCode = "200",
               description = "A list of Orders is returned ",
               content= @Content(mediaType = "application/json",
                   schema = @Schema(implementation = Orders.class))), //200 is a working code 
           @ApiResponse(
               responseCode ="400",
               description = "The request parameters are invalid ",
               content = @Content(mediaType = "application/json")), // 400 is bad input 
           @ApiResponse(
               responseCode = "404",
               description = "No customers were found with the input criteria.",
               content = @Content(mediaType = "application/json")), // 404 not found
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred",
               content = @Content(mediaType = "application/json")) // 500 is an unplanned exception
       })
     
 @GetMapping
 @ResponseStatus(code = HttpStatus.OK)
   
 List<Orders> fetchOrders();

}
