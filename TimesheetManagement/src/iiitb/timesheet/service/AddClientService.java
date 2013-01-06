package iiitb.timesheet.service;

import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class AddClientService {
	
	
	public int addClient(String name,String email,long phone,String city){
		
		
		System.out.println(name);
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		String username =name;
		String password = getPassword(name);
		
		
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			String sql="insert into client("+"client_name,"+
			"email,"+
			"phone,"+
			"city,"+
			"username,"+ 
			"password) "+  
			"values("+
			//			"'',"+
			"'"+name+"' ,"+
			"'"+email+"' ,"+
			"'"+phone+"' ,"+
			"'"+city+"' ,"+
			"'"+username+"' ,"+
			"'"+password+"'"+
			");";
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			int autoIncKeyFromApi = -1;
			
			rs=stmt.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
				throw new Exception("key not generated!");
			}
			rs.close();
			
			
			
			if (stmt != null) 
				stmt.close();
			con.close();
			//returns the patient id
			return autoIncKeyFromApi;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	

	
	
	public  String getPassword(String name){

		String credentials="";
		int randomInt = 0;
	
		
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1000; ++idx){
	      randomInt = randomGenerator.nextInt(10000);
	    }
	    
		credentials=name+"@"+randomInt;


		return credentials;
	}
}
