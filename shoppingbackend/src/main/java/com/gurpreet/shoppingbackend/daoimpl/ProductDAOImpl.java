package com.gurpreet.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurpreet.shoppingbackend.dao.ProductDAO;
import com.gurpreet.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	/* single product */
	@Override
	public Product get(int productID) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productID));
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}

	@Override
	public boolean add(Product product) {

		try {
			
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {

		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "From Product WHERE active = :active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts).setParameter("active", true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProductsByCategory(int categoryID) {

		String selectActiveProductsByCategory = "From Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory)
				.setParameter("active", true).setParameter("categoryId", categoryID).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active=:active ORDER BY id")
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).list();

	}

}
