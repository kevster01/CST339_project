package net.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.model.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

}
