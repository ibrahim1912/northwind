package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.CreateRequestAddToOrder;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CartService {

	Result add (CreateCartRequest createCartRequest);
	Result addToOrder( CreateCartRequest createCartRequest);

    Result update(UpdateCartRequest updateCartRequest);

    Result delete(DeleteCartRequest deleteCartRequest);

    DataResult<CartListResponse> getById(int cartId);
    
	DataResult<List<CartListResponse>> getAll();
	
	
}
