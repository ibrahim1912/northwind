package com.etiya.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateOrderRequest createOrderRequest){
		return this.orderService.add(createOrderRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
		return this.orderService.delete(deleteOrderRequest);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateOrderRequest updateOrderRequest){
		return this.orderService.update(updateOrderRequest);
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<OrderGetResponse> getById(@RequestParam int id){
		return this.orderService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
}
