package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
	
	@Id
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_title")
	private String contactTitle;
	
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="supplier")
	private List<Product> products;

}
