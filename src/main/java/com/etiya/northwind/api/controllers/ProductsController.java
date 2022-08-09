package com.etiya.northwind.api.controllers;

import java.util.List;

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
import com.etiya.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	@PostMapping("/add")
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        this.productService.delete(deleteProductRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateProductRequest updateProductRequest) {
        this.productService.update(updateProductRequest);
    }
    
    @GetMapping("/getbyid")
    public ProductGetResponse getById(@RequestParam int id) {
        return this.productService.getById(id);
    }
	
	@GetMapping("/getall")
	public List<ProductListResponse> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getallbypage")
	public List<ProductListResponse> getAll(@RequestParam int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallsortedbyasc")
	public  List<ProductListResponse> getAllSortedByAsc(@RequestParam String field){
		return this.productService.getAllSortedByAsc(field);
	}
	
	@GetMapping("/getallsortedbydesc")
	public  List<ProductListResponse> getAllSortedByDesc(@RequestParam String field){
		return this.productService.getAllSortedByDesc(field);
	}
}
