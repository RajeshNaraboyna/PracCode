package com.pattern.factory;

public class ProductFactory {
	private static ProductFactory  instance;
	private static final String ID1 = null;
	private static final String ID2 = null;

	public Product createProduct(String ProductID) {
		if (ProductID == ID1)
			return new OneProduct();
		if (ProductID == ID2)
			return new AnotherProduct();
		// ... // so on for the other Ids

		return null; // if the id doesn't have any of the expected values
	}

	public static ProductFactory instance() {

			synchronized(ProductFactory.class){
				if(null==instance)instance = new ProductFactory();
			}
		return instance;
	}

	public void registerProduct(String string, Class<OneProduct> class1) {
		// TODO Auto-generated method stub
		
	}
}
