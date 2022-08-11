package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderGetResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public Result add(CreateOrderRequest createOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
		this.orderRepository.save(order);
		
		return new SuccessResult("ORDER.ADDED");
		
	}

	@Override
	public Result delete(DeleteOrderRequest deleteOrderRequest) {
		this.orderRepository.deleteById(deleteOrderRequest.getOrderId());
		
		return new SuccessResult("ORDER.DELETED");
	}

	@Override
	public Result update(UpdateOrderRequest updateOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepository.save(order);
		
		return new SuccessResult("ORDER.UPDATED");
		
	}

	@Override
	public DataResult<OrderGetResponse> getById(int id) {
		Order order = this.orderRepository.findById(id);
		OrderGetResponse response = this.modelMapperService.forResponse().map(order, OrderGetResponse.class);
		
		return new SuccessDataResult<OrderGetResponse>(response);
	}
	
	@Override
	public DataResult<List<OrderListResponse>> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = result.stream()
				.map(order -> this.modelMapperService.forResponse().map(order, OrderListResponse.class))
				.collect(Collectors.toList());
		
		for(int i=0; i<response.size(); i++) {
			response.get(i).setEmployeeFullName(result.get(i).getEmployee().getFirstName() 
					+ " " + result.get(i).getEmployee().getLastName());
		}
		
		return new SuccessDataResult<List<OrderListResponse>>(response);
	}
}
