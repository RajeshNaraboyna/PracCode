package com.pattern.factory;

public class OneProduct extends Product {
	static {
		ProductFactoryNoRef.instance().registerProduct("ID1",new OneProduct());
	}

	@Override
	public Product createProduct() {
		return new OneProduct();
	}
}
