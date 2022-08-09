package com.etiya.northwind.business.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailListResponse {
	private int orderId;
	private double unitPrice;
	private int quantity;
	private double discount;
	private int productId;
	private String productName;

	private String categoryName;
	private String customerContactName;

}
