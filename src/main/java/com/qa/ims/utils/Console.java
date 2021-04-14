package com.qa.ims.utils;

import java.util.Scanner;

public class Console {
	
	private static Scanner input;

	public Console() {
		super();
		input = new Scanner(System.in);
	}
	
	public static String userInput() {
		return input.nextLine();
	}
	
	public static void generateReport(String result) {
		String report = "\n========================================\n" +
				"===\tResults:\n" +
				"========================================\n\n" +
				result.toString() + "\n" +
				"========================================\n\n";
		System.out.println(report);
		System.out.println("\n\t -- Please press enter to continue --\n\n");
		userInput();
	}

	public static void close() {
		input.close();
		System.out.println("\t- Console has closed.");
	}
	
}
