package com.qa;

import com.qa.ims.IMS;

public class Runner {

	public static void main(String[] args) {
		// create our database/allocation it memory
		IMS myIMS = new IMS();
		
		// begin our application
		myIMS.start();		
	}

}
