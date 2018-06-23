package com.gurpreet.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gurpreet.shoppingbackend.dao.UserDAO;
import com.gurpreet.shoppingbackend.dto.Address;
import com.gurpreet.shoppingbackend.dto.Cart;
import com.gurpreet.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.gurpreet.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	// @Test
	// public void testAdd() {
	//
	// user = new User();
	// user.setFirstName("John");
	// user.setLastName("Cena");
	// user.setEmail("cena@gmail.com");
	// user.setContactNumber("123456789");
	// user.setRole("USER");
	// user.setPassword("12345");
	//
	// // add the user
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	//
	// address = new Address();
	// address.setAddressLineOne(" 1 street nyc ");
	// address.setAddressLineTwo(" apt 2");
	// address.setCity("New York");
	// address.setState("New York");
	// address.setCountry("USA");
	// address.setPostalCode("400001");
	// address.setBilling(true);
	//
	//
	// //link the user with the address using user id
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add address!", true, userDAO.addAddress(address));
	//
	//
	// if(user.getRole().equals("USER")) {
	//
	// //cart for the user
	// cart = new Cart();
	// cart.setUser(user);
	//
	// assertEquals("Failed to add cart!", true, userDAO.updateCart(cart));
	//
	// // add shipping address to the user
	// address = new Address();
	// address.setAddressLineOne(" 1 street nyc ");
	// address.setAddressLineTwo(" apt 2");
	// address.setCity("New York");
	// address.setState("New York");
	// address.setCountry("USA");
	// address.setPostalCode("400001");
	// // set shipping to true
	// address.setBilling(false);
	//
	// //link it with the user
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add address!", true, userDAO.addAddress(address));
	// }
	//
	//
	// }

	/*
	 * @Test public void testUpdateCart() { user =
	 * userDAO.getByEmail("cena@gmail.com");
	 * 
	 * cart = user.getCart(); cart.setGrandTotal(5555); cart.setCartLines(2);
	 * 
	 * assertEquals("Failed to update the cart",true,userDAO.updateCart(cart));
	 * 
	 * }
	 */
/*
	@Test
	public void testAddress() {

		user = new User();
		user.setFirstName("John");
		user.setLastName("Cena");
		user.setEmail("cena@gmail.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("12345");

		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne(" 1 street nyc ");
		address.setAddressLineTwo(" apt 2");
		address.setCity("New York");
		address.setState("New York");
		address.setCountry("USA");
		address.setPostalCode("400001");
		address.setBilling(true);
		address.setUser(user); // user attach

		assertEquals("Failed to add address!", true, userDAO.addAddress(address));

		address = new Address();
		address.setAddressLineOne(" abc colony ");
		address.setAddressLineTwo(" abc area");
		address.setCity(" mumbai	");
		address.setState(" maharastra");
		address.setCountry("india");
		address.setPostalCode("220001");
		address.setShipping(true);
		address.setUser(user); // user attach

		assertEquals("Failed to add Shipping address!", true, userDAO.addAddress(address));

	}
	
	*/
	
	@Test 
	public void testAddress() {
		
		user = userDAO.getByEmail("cena@gmail.com");
		
/*		
		address = new Address();
		address.setAddressLineOne(" xyz colony ");
		address.setAddressLineTwo(" xyz area");
		address.setCity(" delhi");
		address.setState(" delhi ");
		address.setCountry("india");
		address.setPostalCode("110001");
		address.setShipping(true);
		address.setUser(user); // user attach
*/
		assertEquals("Failed to add Shipping address!",2, 
				userDAO.listShippinAddresses(user).size());
		
		assertEquals("Failed to add Shipping address!","New York", 
				userDAO.getBillingAddress(user).getCity());
		
		
		
		
		
		
	}
	
	

}
