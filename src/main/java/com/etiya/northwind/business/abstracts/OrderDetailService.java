package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import com.etiya.northwind.entities.concretes.Product;

public interface OrderDetailService {

	void add(CreateOrderDetailRequest createOrderDetailRequest);
	void delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	void update(UpdateOrderDetailRequest updateOrderDetailRequest);
	
	OrderDetailGetResponse getById(int orderId,int productId);
	List<OrderDetailListResponse> getAll();
}
