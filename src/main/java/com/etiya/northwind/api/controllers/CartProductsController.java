package com.etiya.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartProductService;
import com.etiya.northwind.business.requests.cartproducts.CreateCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.DeleteCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.UpdateCartProductRequest;
import com.etiya.northwind.business.responses.cartProducts.CartProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cartproducts")
public class CartProductsController {

	private CartProductService cartProductService;

	@Autowired
	public CartProductsController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCartProductRequest createCartProductRequest) {
		return this.cartProductService.add(createCartProductRequest);
	}

	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteCartProductRequest deleteCartProductRequest) {
		return this.cartProductService.delete(deleteCartProductRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCartProductRequest updateCartProductRequest) {
		return this.cartProductService.update(updateCartProductRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<CartProductListResponse> getById(int cartProductId) {
		return this.cartProductService.getById(cartProductId);
	}

	@GetMapping("/getall")
	public DataResult<List<CartProductListResponse>> getAll() {
		return this.cartProductService.getAll();
	}
}
