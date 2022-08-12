package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.cartproducts.CreateCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.DeleteCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.UpdateCartProductRequest;
import com.etiya.northwind.business.responses.cartProducts.CartProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CartProductService {

	Result add(CreateCartProductRequest createCartProductRequest);

	Result update(UpdateCartProductRequest updateCartProductRequest);

	Result delete(DeleteCartProductRequest deleteCartProductRequest);

	DataResult<List<CartProductListResponse>> getAll();

	DataResult<CartProductListResponse> getById(int cartProductId);
}
