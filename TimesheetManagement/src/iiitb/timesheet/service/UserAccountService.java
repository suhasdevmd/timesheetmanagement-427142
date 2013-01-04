package iiitb.timesheet.service;

import iiitb.timesheet.model.*;
import iiitb.timesheet.util.DB;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAccountService {
	
	public static String findOldPassword(String selectionModifier) {
		
		UserAccount ua = new UserAccount();
		java.sql.ResultSet resultSet = null;
		String query = "select password from useraccount"+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			while (resultSet.next()) {
				String password = resultSet.getString("password");
				ua.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return ua.getPassword();
	}
	
	public static void updatePasswordUserAccount(String selectionModifier, String value) {
		
		java.sql.Connection connection = DB.getConnection();
		String query = "Update useraccount set password = '"+value+"' "+selectionModifier;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updatePasswordClient(String selectionModifier, String value) {
		
		java.sql.Connection connection = DB.getConnection();
		String query = "Update client set password = '"+value+"' "+selectionModifier;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
