package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartProductService;
import com.etiya.northwind.business.requests.cartproducts.CreateCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.DeleteCartProductRequest;
import com.etiya.northwind.business.requests.cartproducts.UpdateCartProductRequest;
import com.etiya.northwind.business.responses.cartProducts.CartProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.ErrorDataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartProductRepository;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.CartProduct;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class CartProductManager implements CartProductService{

	CartProductRepository cartProductRepository;
    ModelMapperService modelMapperService;
    ProductRepository productRepository;

    @Autowired
    public CartProductManager(CartProductRepository cartProductRepository, 
    		ModelMapperService modelMapperService,ProductRepository productRepository) {
        this.cartProductRepository = cartProductRepository;
        this.modelMapperService = modelMapperService;
        this.productRepository = productRepository;
    }

    @Override
    public Result add(CreateCartProductRequest createCartProductRequest) {
        CartProduct cartProduct = this.modelMapperService.forRequest().map(createCartProductRequest, CartProduct.class);
        Product product = this.productRepository.findById(createCartProductRequest.getProductId());
        cartProduct.setUnitPrice(product.getUnitPrice());
        this.cartProductRepository.save(cartProduct);
        return  new SuccessResult();
    }

    @Override
    public Result update(UpdateCartProductRequest updateCartProductRequest) {
        CartProduct cartProduct = this.modelMapperService.forRequest().map(updateCartProductRequest, CartProduct.class);
        this.cartProductRepository.save(cartProduct);
        return new SuccessResult();
    }

    @Override
    public Result delete(DeleteCartProductRequest deleteCartProductRequest) {
        this.cartProductRepository.deleteById(deleteCartProductRequest.getCartProductId());
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CartProductListResponse>> getAll() {
        List<CartProduct> result = this.cartProductRepository.findAll();
        List<CartProductListResponse> responses = result.stream().map(cartProduct -> this.modelMapperService.forResponse()
                .map(cartProduct,CartProductListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CartProductListResponse>>(responses);
    }

    @Override
    public DataResult<CartProductListResponse> getById(int cartProductId) {
        CartProductListResponse response = new CartProductListResponse();
        if(this.cartProductRepository.existsById(cartProductId)){
            CartProduct cartProduct = this.cartProductRepository.findById(cartProductId).get();
            response = modelMapperService.forResponse().map(cartProduct, CartProductListResponse.class);
            return new SuccessDataResult<CartProductListResponse>(response);
        }
        else{
            System.out.println("Geçersiz Sepet Id");
            return new ErrorDataResult<CartProductListResponse>(response);
        }
    }

}
