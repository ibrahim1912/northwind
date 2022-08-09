package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderGetResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateOrderRequest createOrderRequest){
		this.orderService.add(createOrderRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
		this.orderService.delete(deleteOrderRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateOrderRequest updateOrderRequest){
		this.orderService.update(updateOrderRequest);
	}
	
	
	@GetMapping("/getbyid")
	public OrderGetResponse getById(@RequestParam int id){
		return this.orderService.getById(id);
	}
	@GetMapping("/getall")
	public List<OrderListResponse> getAll(){
		return this.orderService.getAll();
	}
}
