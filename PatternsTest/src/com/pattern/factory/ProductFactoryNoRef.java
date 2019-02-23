package com.pattern.factory;

import java.util.HashMap;

public class ProductFactoryNoRef {

	private static HashMap<String, Product> m_RegisteredProducts = new HashMap<>();
	private static ProductFactoryNoRef instance;

	private ProductFactoryNoRef() {
		
	}

	public  static void registerProduct(String productID, Product p) {
		synchronized (ProductFactoryNoRef.class) {
			m_RegisteredProducts.put(productID, p);
		}
	}

	public Product createProduct(String productID) {
		return (m_RegisteredProducts.get(productID)).createProduct();
	}

	public static ProductFactoryNoRef instance() {
		synchronized (ProductFactoryNoRef.class) {
			if (null == instance)
				instance = new ProductFactoryNoRef();
		}
		return instance;
	}

//	public static void registerProduct(String productID, Product prod) {
//		m_RegisteredProducts.put(productID, prod);
//	}

}
