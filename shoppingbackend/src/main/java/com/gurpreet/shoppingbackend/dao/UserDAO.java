package com.gurpreet.shoppingbackend.dao;

import java.util.List;

import com.gurpreet.shoppingbackend.dto.Address;
import com.gurpreet.shoppingbackend.dto.Cart;
import com.gurpreet.shoppingbackend.dto.User;

public interface UserDAO {

	//add an user
	boolean addUser(User user);
	// add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippinAddresses(User user);	
	
	//add a cart
	boolean updateCart(Cart cart);
	
	User getByEmail(String email);
	
}
