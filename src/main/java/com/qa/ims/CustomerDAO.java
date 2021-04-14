package com.qa.ims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	
	private DatabaseConnection database;
	private PreparedStatement prepSt;

	public CustomerDAO() {
		super();
		this.database = new DatabaseConnection();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDTO mapToDTO(ResultSet set) {
		try {
			if(set.next()) {
				return new CustomerDTO(set.getInt(1), set.getString(2), set.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void create(CustomerDTO cust) {		
		Connection connection = database.getConnection();
		try {
			prepSt = connection.prepareStatement("INSERT INTO CUSTOMERS(first_name, surname) VALUES(?,?)");
			prepSt.setString(1, cust.getForename());
			prepSt.setString(2, cust.getSurname());
			
			prepSt.executeUpdate();
			
			System.out.println("Entry:\n"+cust.toString()+"\n\nhas now been added!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CustomerDTO read(Integer id) {		
		Connection connection = database.getConnection();
		try {
			prepSt = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID = ?");
			prepSt.setInt(1, id);
			
			System.out.println(prepSt.toString());
			
			ResultSet result = prepSt.executeQuery();
			
			return mapToDTO(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
