package com.qa.ims;

public class IMS {
	
	private CustomerController controller;

	public IMS() {
		super();
		controller = new CustomerController();
	}
	
	public void start() {
		//controller.create();
		controller.read();
		
		close();
	}
	
	public void close() {
		// clean up resources here
		DatabaseConnection.close();
		System.out.println("Database resources have been closed.");
		
		System.out.println("Application has ended.");
	}
	

}
