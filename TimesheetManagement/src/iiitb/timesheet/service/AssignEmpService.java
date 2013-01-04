package iiitb.timesheet.service;

import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AssignEmpService {
	
	public int addAssignment(int pid,String task_name,int emp_id){
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			System.out.println("inside addAssignment ----- ;;;;; ");
			System.out.println(": : "+pid+" : "+task_name+" : "+emp_id);
			
			String sql="insert into assignment("+"pid,"+ 
			"task_name,"+ 
			"emp_id) "+  
			"values("+
			//			"'',"+
			"'"+pid+"' ,"+
			"'"+task_name+"' ,"+
			"'"+emp_id+"'"+
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
	
	
	
	public int getProjectID(String proj_name){
		
		int pid = 0;
		Connection con;
		ResultSet rs;
		String query;
		
		System.out.println("--> the proj name "+proj_name);
		
		try {
			con=DB.getConnection();
			query="select pid from project where project_name="+"'"+proj_name+"'";
			
			System.out.println("b4 qry --> "+query);
			rs=DB.readFromDB(query, con);
			
			
			while(rs.next()){
				pid=rs.getInt("pid");
			}
			
			System.out.println("pid :"+pid);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception occured !!!!");
		}
			
		return pid;
	}
	
	
	
	public int getEmployeeID(String name){
		int emp_id=0;
		
		
		String [] names=name.split(" ");
		Connection con = null;
		ResultSet rs = null;
		String query;
		
		System.out.println("names : : : : "+names[0]+" : "+names[1]);
		
		try {
			con=DB.getConnection();
			query="select emp_id from employee where firstname="+"'"+names[0]+"'"+" and lastname="+"'"+names[1]+"'";
			
			System.out.println("b4 qry --> "+query);
			rs=DB.readFromDB(query, con);
			
			
			while(rs.next()){
				emp_id=rs.getInt("emp_id");
			}
			
			System.out.println("emp_id :"+emp_id);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception occured !!!!");
		}finally{
			DB.close(con);
			DB.close(rs);
		}
		
		
		
		return emp_id;
	}

}