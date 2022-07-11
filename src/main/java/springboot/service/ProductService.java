package net.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.springboot.model.Product;

public interface ProductService {

	
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductById(String id);
	void deleteProductById(String id);
	Page<Product> findPaginated(int pageNo, int pageSize, String productDescription, String productPrice);
}

