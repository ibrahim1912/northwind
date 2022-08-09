package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

public interface SupplierService {

	List<SupplierListResponse> getAll();
}
