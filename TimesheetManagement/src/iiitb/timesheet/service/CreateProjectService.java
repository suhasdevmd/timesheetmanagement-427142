package iiitb.timesheet.service;

import iiitb.timesheet.model.Project;
import iiitb.timesheet.util.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CreateProjectService {


	public int addProject(Project project) throws Exception{

		Connection con;
		Statement stmt;
		ResultSet rs;

		try {
			con=DB.getConnection();
			stmt=con.createStatement();

			String sql="insert into project("+"manager_id,"+ 
			"project_num,"+ 
			"project_name,"+ 
			"description,"+ 
			"startdate,"+ 
			"enddate,"+ 
			"cost_per_hour) "+  
			"values("+
			//			"'',"+
			"'"+project.getManager_id()+"' ,"+
			"'"+project.getProject_num()+"' ,"+
			"'"+project.getProject_name()+"',"+
			"'"+project.getDescription()+"',"+
			"'"+project.getStartdate()+"',"+
			"'"+project.getEnddate()+"',"+
			"'"+project.getCost_per_hour()+"'"+
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


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}




	public int addProject1(Project project) throws Exception{

		Connection con;
		Statement stmt;
		ResultSet rs;

		try {
			con=DB.getConnection();
			stmt=con.createStatement();

			String sql="insert into project("+"manager_id,"+ 
			"project_num,"+ 
			"project_name,"+ 
			"description,"+ 
			"startdate,"+ 
			"enddate,"+ 
			"cost_per_hour,"+
			"client_id) "+
			"values("+
			//			"'',"+
			"'"+project.getManager_id()+"' ,"+
			"'"+project.getProject_num()+"' ,"+
			"'"+project.getProject_name()+"',"+
			"'"+project.getDescription()+"',"+
			"'"+project.getStartdate()+"',"+
			"'"+project.getEnddate()+"',"+
			"'"+project.getCost_per_hour()+"',"+
			"'"+project.getClient_id()+"'"+
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


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}
	
	
	
	public int getClientID(String name){
		
		
		int id = 0;
		
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select client_id from client where client_name="+"'"+name+"';";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				id=rs.getInt("client_id");
			}
			
			System.out.println("id---> "+id);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return id;
		
		
		
		
		
	}

}
