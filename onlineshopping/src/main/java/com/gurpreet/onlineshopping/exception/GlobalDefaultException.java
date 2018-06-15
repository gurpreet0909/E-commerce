package com.gurpreet.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Page is not Constructed");
		mv.addObject("errordescription", "page not available now !!!");
		mv.addObject("title", " 404 page error  ....");

		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errordescription", "product  not available now !!!");
		mv.addObject("title", " Product Unavailable...");

		return mv;
	}
	
	

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contact your adminitrator !!!");
		mv.addObject("errordescription", ex.toString());
		mv.addObject("title", " Error");
		
		
	
		return mv;
	}
	
}
