package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface OrderDetailService {

	Result add(CreateOrderDetailRequest createOrderDetailRequest);
	Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
	
	DataResult<OrderDetailGetResponse> getById(int orderId,int productId);
	DataResult<List<OrderDetailListResponse>> getAll();
}
