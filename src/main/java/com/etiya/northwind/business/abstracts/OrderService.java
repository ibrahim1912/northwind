package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderGetResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface OrderService {

	Result add(CreateOrderRequest createOrderRequest);
	Result delete(DeleteOrderRequest deleteOrderRequest);
	Result update(UpdateOrderRequest updateOrderRequest);
	
	DataResult<OrderGetResponse> getById(int id);
	DataResult<List<OrderListResponse>> getAll();
 }
