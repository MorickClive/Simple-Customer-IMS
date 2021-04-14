package com.qa.ims;

public class CustomerService {
	
	private CustomerDAO dao;

	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = new CustomerDAO();
	}
	
	public void create(CustomerDTO cust) {
		dao.create(cust);
	}
	
	public void read(Integer id) {
		CustomerDTO result = dao.read(id);
		
		System.out.println(result.toString());
	}

}
