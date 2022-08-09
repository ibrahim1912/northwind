package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderGetResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

public interface OrderService {

	void add(CreateOrderRequest createOrderRequest);
	void delete(DeleteOrderRequest deleteOrderRequest);
	void update(UpdateOrderRequest updateOrderRequest);
	
	OrderGetResponse getById(int id);
	List<OrderListResponse> getAll();
 }
