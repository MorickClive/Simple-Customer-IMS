package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.daos.CustomerDAO;
import com.qa.ims.persistence.dtos.CustomerDTO;
import com.qa.ims.utils.Console;

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
		
		Console.generateReport(result.toString());
	}
	
	public void readAll() {
		List<CustomerDTO> result = dao.readAll();
		
		StringBuilder reportString = new StringBuilder();
		
		for(CustomerDTO item : result) {
			reportString.append(item.toString() + "\n");
		}
	
		Console.generateReport(reportString.toString());
	}

}
