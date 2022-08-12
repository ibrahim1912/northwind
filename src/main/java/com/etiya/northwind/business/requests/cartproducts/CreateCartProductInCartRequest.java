package com.etiya.northwind.business.requests.cartproducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartProductInCartRequest {

  
    private int productId;
   // private double unitPrice;
    private int quantity;



}