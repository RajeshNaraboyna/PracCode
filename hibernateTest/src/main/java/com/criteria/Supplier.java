package com.criteria;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	private String supplierId;

	private String supplierName;
	
	

	public Supplier() {
		super();
	}

	public Supplier(String string) {
	}

	public List<Product> getProducts() {
		return null;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

}
