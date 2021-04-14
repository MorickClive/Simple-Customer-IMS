package com.qa.ims;

public class CustomerController {
	
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
		service.read(27);		
	}
	
}
