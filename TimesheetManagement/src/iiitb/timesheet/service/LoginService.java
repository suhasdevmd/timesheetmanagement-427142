package iiitb.timesheet.service;


import iiitb.timesheet.model.Client;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.util.DB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
public class LoginService {


	Map session=ActionContext.getContext().getSession();
	
	public String AuthenticateUser(String username,String pass){

		ResultSet rs=null;
		ResultSet rs1=null;

		try {
			
			String user = IfUserClient(username, pass);
			if(user!=null)
				return user;
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DB.getConnection();
			java.sql.Statement statement = connection.createStatement();
			String sql="select * from  useraccount where username = '"+username+"' and password= '"+pass+"' ";

			rs=statement.executeQuery(sql);	
			
			if(rs.next()){
				try {
					
					int empid = rs.getInt("emp_id");
                    ArrayList<Employee> empdetails = EmployeeService.findEmployeeDetails(" where emp_id = "+empid);
                    
                    session.put("EmployeeDetails", empdetails);
					
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					java.sql.Connection connection1=DB.getConnection();
					java.sql.Statement statement1 = connection.createStatement();
					String sql1="select * from role where role_id = '"+rs.getString("role_id")+"' ";
					rs1=statement1.executeQuery(sql1);
					
					System.out.println("B4");
					
					if(rs1.next()) 
						return rs1.getString("role_name");
					//else {
						
						System.out.println("inside auth");
						
						
					//}
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

		
		System.out.println("inside client");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DB.getConnection();
			java.sql.Statement statement = connection.createStatement();
			String sql="select * from  client where username = '"+username+"' and password= '"+pass+"' ";

			rs=statement.executeQuery(sql);	
			if(rs.next()){
				
				Client client = new Client();
                ArrayList<Client> clientdetails = new ArrayList<Client>();
                
                int client_id = rs.getInt("client_id");
                client.setClient_id(client_id);
                
                String client_name = rs.getString("client_name");
                client.setClient_name(client_name);
                
                String usrname = rs.getString("username");
                client.setUsername(usrname);
                
                String pwd = rs.getString("password");
                client.setPassword(pwd);
                
                String city = rs.getString("city");
                client.setCity(city);
                
                String email = rs.getString("email");
                client.setEmail(email);
                
                int phone_num = rs.getInt("phone");
                client.setPhone_num(phone_num);
                
                clientdetails.add(client);
                
                session.put("ClientDetails", clientdetails);
                
                //return "client";
				
				
				
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

