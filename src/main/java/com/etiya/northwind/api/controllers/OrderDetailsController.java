package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import com.etiya.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {


	private OrderDetailService orderDetailService;

	@Autowired
	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest){
		this.orderDetailService.add(createOrderDetailRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest){
		this.orderDetailService.delete(deleteOrderDetailRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest){
		this.orderDetailService.update(updateOrderDetailRequest);
	}
	
	
	@GetMapping("/getbyid")
	public OrderDetailGetResponse getById(@RequestParam int orderId,@RequestParam int productId){
		return this.orderDetailService.getById(orderId,productId);
	}
	
	@GetMapping("/getall")
	public List<OrderDetailListResponse> getAll(){
		return this.orderDetailService.getAll();
	}
}
