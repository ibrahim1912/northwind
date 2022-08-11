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

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductGetResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }
	
	
    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteProductRequest deleteProductRequest) {
    	return this.productService.delete(deleteProductRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }
    
    @GetMapping("/getbyid")
    public DataResult<ProductGetResponse> getById(@RequestParam int id) {
        return this.productService.getById(id);
    }
	
	@GetMapping("/getall")
	public DataResult<List<ProductListResponse>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getallbypage")
	public DataResult<List<ProductListResponse>>getAll(@RequestParam int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallsortedbyasc")
	public  DataResult<List<ProductListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.productService.getAllSortedByAsc(field);
	}
	
	@GetMapping("/getallsortedbydesc")
	public  DataResult<List<ProductListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.productService.getAllSortedByDesc(field);
	}
}
