package iiitb.timesheet.service;

import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManagerService {
	
	
	
	public ArrayList<String> getProjects(){
		
		ArrayList<String> projects = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select project_name from project";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				projects.add(rs.getString("project_name"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return projects;
	}
	
	
	public ArrayList<String> getEmployees(){
		ArrayList<String> employees = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select firstname,lastname from employee";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				employees.add(rs.getString("firstname")+" "+rs.getString("lastname"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return employees;
	}
	
	
	
	
	
	
	
	
	
	public ArrayList<String> getEmployeesFromDB(){
		ArrayList<String> employees = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select firstname,lastname from employee where emp_id not in (select emp_id from assignment)";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				employees.add(rs.getString("firstname")+" "+rs.getString("lastname"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return employees;
	}
	
	
	
	
	
	
	
	public ArrayList<Timesheet> getTimesheets(int manager_id){
		ArrayList<Timesheet> timesheets=new ArrayList<Timesheet>();
		
		
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			/*query="select project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' ";*/
			
			query="select t.timesheet_id,project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' and a.manager_id="+"'"+manager_id+"';";
			
			
			
			rs=DB.readFromDB(query, con);
			
			//System.out.println("sssssss "+query);
			
			while(rs.next()){
				// create timesheet object and add to arraylist
				//System.out.println(rs.getInt("timesheet_id"));
				
				
				
				Timesheet timesheet=new Timesheet();
				timesheet.setTimesheet_id(rs.getInt("timesheet_id"));
				timesheet.setProject_num(rs.getInt("project_num"));
				timesheet.setTask_name(rs.getString("task_name"));
				timesheet.setEmp_id(rs.getInt("emp_id"));
				timesheet.setEmp_name(getEmpName(rs.getInt("emp_id")));
				
				timesheet.setWork_date(rs.getString("work_date"));
				timesheet.setNo_of_hours(rs.getFloat("no_of_hours"));
				
				timesheets.add(timesheet);
			
				
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return timesheets;
	}
	
	
	
	public ArrayList<String> getClients(){
		ArrayList<String> clients = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select client_name from client";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				clients.add(rs.getString("client_name"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return clients;
		
	}
	
	
	public String getEmpName(int emp_id){
		String name="";
		
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select firstname,lastname from employee where emp_id="+"'"+emp_id+"'";
			rs=DB.readFromDB(query, con);
			
			
			System.out.println("Get emp name query  : "+query);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				name=rs.getString("firstname")+" "+rs.getString("lastname");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return name;
	}

}
