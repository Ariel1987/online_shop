package onlineshop.entities.implementation;

import java.util.Arrays;

import onlineshop.entities.Cart;
import onlineshop.entities.Product;

public class DefaultCart implements Cart {

	private static final int DEFAULT_PRODUCT_CAPACITY = 10;
	Product[] products;
	private int lastIndex;
	
	{
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}
	
	@Override
	public boolean isEmpty() {

		if(products == null || products.length == 0) {
			return true;
		}
		
		for(Product product: products) {
			if(product != null) {
				return false;
			}
		}

		return true;

	}

	@Override
	public void addProduct(Product productById) {
		
		if(productById == null) {
			return;
		}

		if (products.length <= lastIndex) {
			products = Arrays.copyOf(products, products.length << 1);
		}

		products[lastIndex++] = productById;
		
	}

	@Override
	public Product[] getProducts() {

		int nonNullProductsAmount = 0;
		for (Product product : products) {
			if (product != null) {
				nonNullProductsAmount++;
			}
		}
		
		Product[] nonNullProducts = new Product[nonNullProductsAmount];
		int index = 0;
		for (Product product : products) {
			if (product != null) {
				nonNullProducts[index++] = product;
			}
		}
		
		return nonNullProducts;
	
	}

	@Override
	public void clear() {
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}


}
