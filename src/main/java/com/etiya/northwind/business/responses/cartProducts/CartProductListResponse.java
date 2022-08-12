package com.etiya.northwind.business.responses.cartProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductListResponse {

    private int cartProductId;
    private int cartCartId;
    private int productId;
    private double unitPrice;
    private int quantity;
}