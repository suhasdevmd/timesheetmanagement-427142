package iiitb.timesheet.service;


import iiitb.timesheet.util.DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
public class LoginService {
	
	
	public String AuthenticateUser(String username,String pass){
		
		ResultSet rs=null;
		ResultSet rs1=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/timesheet?user=root&password=password");
			java.sql.Statement statement = connection.createStatement();
			String sql="select * from  useraccount where username = '"+username+"' and password= '"+pass+"' ";
			
			rs=statement.executeQuery(sql);	
			if(rs.next()){
				try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				java.sql.Connection connection1=DB.getConnection();
				java.sql.Statement statement1 = connection.createStatement();
				String sql1="select * from role where role_id = '"+rs.getString(3)+"' ";
				rs1=statement1.executeQuery(sql1);
				if(rs1.next()) 
				return rs1.getString(2);
				else {
					String user = IfUserClient(username, pass);
					if(user!=null)
						return user;
				}
				rs1.close();

				if (statement1 != null) 
					statement1.close();
				connection1.close();
				}
				catch (Exception e) {
					System.out.println(" Exception occurred	exception:Exception" + e);
					return null;
				} 
			}else{
				
			}
			rs.close();

			if (statement != null) 
				statement.close();
			connection.close();
				
			
		} catch (Exception e) {
			System.out.println(" Exception occurred	exception:Exception" + e);
			return null;
		} 


		return null;
		
	}
public String IfUserClient(String username,String pass){
		
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DB.getConnection();
			java.sql.Statement statement = connection.createStatement();
			String sql="select * from  client where username = '"+username+"' and password= '"+pass+"' ";
			
			rs=statement.executeQuery(sql);	
			if(rs.next()){
				return "client";
				}else{
				
			}
			rs.close();

			if (statement != null) 
				statement.close();
			connection.close();
				
			
		} catch (Exception e) {
			System.out.println(" Exception occurred	exception:Exception" + e);
			return null;
		} 


		return null;
		
	}

}

