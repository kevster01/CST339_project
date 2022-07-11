package net.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import net.springboot.model.Product;
import net.springboot.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository ProductRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return ProductRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		this.ProductRepository.save(product);
	}


	@Override
	public Product getProductById(String id) {
		Optional<Product> optional = ProductRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException(" Product not found for id :: " + id);
		}
		return product;
	}

	@Override
	public void deleteProductById(String id) {
		// TODO Auto-generated method stub
		this.ProductRepository.deleteById(id);
		
	}

	@Override

	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.ProductRepository.findAll(pageable);
	}
}
