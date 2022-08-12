package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartProductRepository;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.entities.concretes.Cart;

@Service
public class CartManager implements CartService {

	private CartRepository cartRepository;
	private ModelMapperService modelMapperService;
	private CartProductRepository cartProductRepository;

	@Autowired
	public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService,
			CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.modelMapperService = modelMapperService;
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public Result add(CreateCartRequest createCartRequest) {
		Cart cart = this.modelMapperService.forRequest().map(createCartRequest, Cart.class);
		this.cartRepository.save(cart);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateCartRequest updateCartRequest) {
		Cart cart = this.modelMapperService.forRequest().map(updateCartRequest, Cart.class);
		this.cartRepository.save(cart);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCartRequest deleteCartRequest) {
		this.cartProductRepository.deleteById(deleteCartRequest.getCartId());
		return new SuccessResult();
	}

	@Override
	public DataResult<CartListResponse> getById(int cartId) {
		Cart cart = this.cartRepository.findById(cartId).get();
		CartListResponse response = this.modelMapperService.forRequest().map(cart, CartListResponse.class);
		
		return new SuccessDataResult<CartListResponse>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAll() {
		List<Cart> result = this.cartRepository.findAll();
		List<CartListResponse> response = result.stream()
				.map(cart -> this.modelMapperService.forResponse().map(cart, CartListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CartListResponse>>(response);
	}

}
