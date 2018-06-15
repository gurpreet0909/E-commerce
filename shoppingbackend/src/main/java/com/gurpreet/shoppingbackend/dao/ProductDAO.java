package com.gurpreet.shoppingbackend.dao;

import java.util.List;

import com.gurpreet.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productID);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// business methods
	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryID);

	List<Product> getLatestActiveProducts(int count);
}
