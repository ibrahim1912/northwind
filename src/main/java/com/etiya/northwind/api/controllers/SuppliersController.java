package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping("/getall")
	public List<SupplierListResponse> getAll(){
		return this.supplierService.getAll();
	}
}
