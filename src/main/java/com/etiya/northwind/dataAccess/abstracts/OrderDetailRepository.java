package com.etiya.northwind.dataAccess.abstracts;


import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import com.etiya.northwind.entities.concretes.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

	//OrderDetail deleteById(int orderId,int productId);
//	@Modifying
//	@Query("Select od  from order_details od where order_id = :orderId and product_id = :productId")
//	OrderDetail getByOrderIdAndProductId(@Param("orderId") Integer orderId,@Param("productId") Integer productId);
	
	
	//OrderDetail getByOrderDetailIdOrderAndProduct( OrderDetailId orderId,OrderDetailId productId);
//	@Query(" from orderDetails where orderId = :orderId and productId = :productId")
//	OrderDetail getByOrderAndProduct( int orderId,int productId);
	
	//@Query("Select  od.orderId,od.productId from orderDetails od where orderId = :orderId and productId = :productId")
	
	OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);
	
	
	
}
