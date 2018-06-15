package com.gurpreet.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurpreet.shoppingbackend.dao.CategoryDAO;
import com.gurpreet.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();
	
	static {

		Category category = new Category();
		category.setId(1);
		category.setName("  Laptop");
		

		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("  Television");
		

		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("  Mobile");
	
		categories.add(category);

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		
		return false;
	}

	@Override
	public boolean delete(Category category) {
		
		return false;
	}

}
