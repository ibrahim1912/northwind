package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.SupplierGetResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface SupplierService {
	Result add(CreateSupplierRequest createSupplierRequest);
	Result delete(DeleteSupplierRequest deleteSupplierRequest);
	Result update(UpdateSupplierRequest updateSupplierRequest);
	
	DataResult<SupplierGetResponse> getById(int id);
	DataResult<List<SupplierListResponse>> getAll();
}
