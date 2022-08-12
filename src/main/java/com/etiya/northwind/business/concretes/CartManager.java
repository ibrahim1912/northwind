package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.CreateRequestAddToOrder;
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
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class CartManager implements CartService{

	private CartRepository cartRepository;
	private ModelMapperService modelMapperService;
	private OrderDetailRepository orderDetailRepository;
	private OrderRepository orderRepository;
	private CartProductRepository cartProductRepository;

	
	@Autowired
	public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService,
			OrderDetailRepository orderDetailRepository,OrderRepository orderRepository,CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.modelMapperService = modelMapperService;
		this.orderDetailRepository=orderDetailRepository;
		this.orderRepository=orderRepository;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DataResult<List<CartListResponse>> getAll() {
		List<Cart> result = this.cartRepository.findAll();
		List<CartListResponse> response = result.stream()
				.map(cart -> this.modelMapperService.forResponse().map(cart, CartListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CartListResponse>>(response);
	}
	
	@Override
	public Result addToOrder(CreateCartRequest createCartRequest) {
		
		Order order = this.modelMapperService.forRequest().map(createCartRequest, Order.class);
//		Order order = this.modelMapperService.forRequest().
//				map(createRequestAddToOrder, Order.class);
//		this.orderRepository.save(order);
//		addToOrderDetail(createRequestAddToOrder);
		
		//this.cartRepository.deleteCartWithCustomerIdAndProductId(createRequestAddToOrder.getCustomerId(), createRequestAddToOrder.getProductId());
		//this.cartProductRepository.deleteCartWithCartId();
		//this.cartRepository.deleteCartWithCustomerNumber(createRequestAddToOrder.getCustomerNumber());
		return new SuccessResult("Order added");
	}
	

	private void addToOrderDetail(CreateRequestAddToOrder createRequestAddToOrder) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().
				map(createRequestAddToOrder, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
	}
	
	 
}
