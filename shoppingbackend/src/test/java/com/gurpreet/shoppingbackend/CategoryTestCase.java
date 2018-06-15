package com.gurpreet.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gurpreet.shoppingbackend.dao.CategoryDAO;
import com.gurpreet.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.gurpreet.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	@Test
	public void testAddCategory() {

		category = new Category();
		category.setName("  Mobile");
		category.setDescription("This is discription of Mobile");
		category.setImageURL("CAT_112.png");

		assertEquals("Successfully added a category inside table", true, categoryDAO.add(category));
	}
	
	
}
