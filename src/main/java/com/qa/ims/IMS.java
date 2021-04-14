package com.qa.ims;

import com.qa.ims.controllers.Controller;
import com.qa.ims.controllers.CustomerController;
import com.qa.ims.utils.Console;
import com.qa.ims.utils.DatabaseConnection;
import com.qa.ims.utils.enums.Action;
import com.qa.ims.utils.enums.Domain;

public class IMS {
	
	private Controller controller;
	private Console console;
	
	private Domain activeDomain;
	
	public IMS() {
		super();
		controller = new CustomerController();
		console = new Console();
	}
	
	public void start() {
		domainMenu();
		close();
	}
	
	private void domainMenu() {

		String menuMsg = "========================================\n" +
						"IMS System:\t Main Menu\n" +
						"========================================\n" + 
						"\t- 1). Customer" + "\n" + 
						"\t- 2). ITEMS" + "\n"+ 
						"\t- 3). Unimplemented" + "\n" +
						"\t=====\n"+ 
						"\t- 0). Exit Application\n"+ 
						"\n" + "========================================\n";
		boolean menuFlag = true;
		Integer menuOption = 0;

		while (menuFlag) {
			System.out.println(menuMsg);
			System.out.println("Please enter an option");
			menuOption = Integer.parseInt(console.userInput());

			switch (menuOption) {
			case 1:
				this.activeDomain = Domain.CUSTOMER;
				actionMenu();
				break;
			case 2:
				this.activeDomain = Domain.ITEMS;
				actionMenu();
				break;
			case 3:
				this.activeDomain = Domain.CUSTOMER;
				actionMenu();
				break;

			default:
				menuFlag = false;
				break;
			}
		}

	}

	private void actionMenu() {
		String menuMsg = "========================================\n" + 
				"IMS System:\t" + this.activeDomain + "\n"+ 
				"========================================\n" + 
				"\t- 1). Create" + "\n" + 
				"\t- 2). Read" + "\n"+ 
				"\t- 3). Read All" + "\n" + 
				"\t- 4). Update" + "\n" + 
				"\t- 5). Delete" + "\n" + 
				"\t=====\n"+ 
				"\t- 0). Return\n" + 
				"========================================\n";
		boolean menuFlag = true;
		Integer menuOption = 0;

		while(menuFlag) {
			System.out.println(menuMsg);
			menuOption = Integer.parseInt(console.userInput());

			switch (menuOption) {
			case 1:
				performAction(Action.CREATE);
				break;
			case 2:
				performAction(Action.READ);
				break;
			case 3:
				performAction(Action.READALL);
				break;
			case 4:
				performAction(Action.UPDATE);
				break;
			case 5:
				performAction(Action.DELETE);
				break;
			case 6:
				menuFlag = false;
				break;

			default:
				menuFlag = false;
				break;
			}
		}
	}

	private void performAction(Action action) {
		Controller activeController = null;

		// determine activeController
		switch (activeDomain) {
		case CUSTOMER:
			activeController = this.controller;
			break;

		case ITEMS:
			activeController = this.controller;
			break;

		default:
			System.out.println("Cannot select Domain, something has gone wrong!");
			break;
		}
		
		// perform action
		switch (action) {

		case CREATE:
			activeController.create();
			break;

		case READ:
			activeController.read();
			break;

		case READALL:
			activeController.readAll();
			break;

		case UPDATE:
			activeController.update();
			break;

		case DELETE:
			activeController.delete();
			break;
		
		default:
			System.out.println("Cannot perform action, something has gone wrong!");
			break;

		}
	}
	
	private void close() {
		// clean up resources here

		System.out.println("\nExiting Application.\n"+
		"========================================");
		
		Console.close();
		DatabaseConnection.close();
		
		System.out.println("\t- Database resources have been closed.");
		System.out.println("Application has ended, have a nice day.");
	}
	

}
