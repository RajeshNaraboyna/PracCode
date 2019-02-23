package com.pattern.factory;

public class AnotherProduct extends Product {

	static {
		ProductFactoryNoRef.instance().registerProduct("ID2", new AnotherProduct());
	}

	@Override
	public Product createProduct() {
		return ProductFactoryNoRef.instance().createProduct("ID2");
	}

}
