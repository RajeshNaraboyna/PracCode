package com.pattern.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ProductFactoryReflection {
	private HashMap m_RegisteredProducts = new HashMap();

	private static ProductFactoryReflection instance;

	private ProductFactoryReflection() {

	}

	public void registerProduct(String productID, Class productClass) {
		m_RegisteredProducts.put(productID, productClass);
	}

	public Product createProduct(String productID) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class productClass = (Class) m_RegisteredProducts.get(productID);
		Constructor productConstructor = productID.getClass().getDeclaredConstructor(new Class[] { String.class });
		return (Product) productConstructor.newInstance(new Object[] {});
	}

	public static ProductFactoryReflection instance() {
		synchronized (ProductFactoryReflection.class) {
			if (null == instance)
				instance = new ProductFactoryReflection();
		}
		return instance;
	}
}
