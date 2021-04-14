package com.qa.ims.controllers;

import com.qa.ims.persistence.dtos.CustomerDTO;
import com.qa.ims.services.CustomerService;
import com.qa.ims.utils.Console;

public class CustomerController implements Controller {
	
	private CustomerService service;

	public CustomerController() {
		super();
		this.service = new CustomerService();
		// TODO Auto-generated constructor stub
	}
	
	public void create() {
		CustomerDTO cust = new CustomerDTO("Angela","Thomas");
		service.create(cust);		
	}
	
	public void read() {
		System.out.println("Please enter a Customer Id to select:\t");
		Integer id = Integer.parseInt(Console.userInput());
		service.read(id);		
	}
	
	public void readAll() {
		service.readAll();		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
