package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.SupplierGetResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

public interface SupplierService {
	void add(CreateSupplierRequest createSupplierRequest);
	void delete(DeleteSupplierRequest deleteSupplierRequest);
	void update(UpdateSupplierRequest updateSupplierRequest);
	
	SupplierGetResponse getById(int id);
	List<SupplierListResponse> getAll();
}
