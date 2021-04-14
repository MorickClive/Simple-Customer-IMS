package com.qa.ims.persistence.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.dtos.CustomerDTO;
import com.qa.ims.utils.DatabaseConnection;

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
			return new CustomerDTO(set.getInt(1), set.getString(2), set.getString(3));
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
			
			ResultSet result = prepSt.executeQuery();
			// .next points to the next available row of data from our queried table
			// - returning true if there is a row "next" in the set, false if not.
			result.next();
			// assuming the row data is a customer(id, name, surname), then:
			result.getInt(1);
			result.getString(2);
			result.getString(3);
			
			// We should probably map our ResultSet 'gets' into a CustomerDTO object
			return mapToDTO(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CustomerDTO> readAll() {		
		Connection connection = database.getConnection();
		try {
			prepSt = connection.prepareStatement("SELECT * FROM CUSTOMERS");
			
			ResultSet set = prepSt.executeQuery();		
			List<CustomerDTO> results = new ArrayList<>();
			
			while(set.next()) {
				results.add(mapToDTO(set));
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
