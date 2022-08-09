package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

public interface OrderDetailService {

	List<OrderDetailListResponse> getAll();
}
