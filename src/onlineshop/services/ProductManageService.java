package onlineshop.services;

import onlineshop.entities.Product;

public interface ProductManageService {
	Product[] getProducts();
	
	Product getProductById(int productIdToAddToCart);

}
