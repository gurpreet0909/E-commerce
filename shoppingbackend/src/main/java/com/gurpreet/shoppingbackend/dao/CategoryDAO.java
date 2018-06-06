package com.gurpreet.shoppingbackend.dao;

import java.util.List;

import com.gurpreet.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);
	
}
