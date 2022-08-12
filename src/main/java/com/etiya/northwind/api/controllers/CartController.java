package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCartRequest createCartRequest){
		return this.cartService.add(createCartRequest);
	}
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCartRequest deleteCartRequest){
		return this.cartService.delete(deleteCartRequest);
	}
	
	@PostMapping("/update")
	public Result update (@RequestBody UpdateCartRequest updateCartRequest){
		return this.cartService.update(updateCartRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartListResponse> getById(int cartId){
		return this.cartService.getById(cartId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartListResponse>> getAll(){
		return this.cartService.getAll();
	}
	


}
