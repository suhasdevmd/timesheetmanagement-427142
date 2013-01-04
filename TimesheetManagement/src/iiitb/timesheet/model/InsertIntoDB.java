package iiitb.timesheet.model;

import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.service.TimeSheetService;
import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sun.nio.cs.ext.TIS_620;

import com.mysql.jdbc.PreparedStatement;

public class InsertIntoDB {
	
	private static int won;
	private static int taskID;
	private static int empID;

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public static String addTimeSheet(int won,String taskname,Date date,float hours){
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();			
			
			System.out.println("inside addTimeSheet----- ;;;;; ");
			System.out.println("won: "+won+" taskname: "+taskname+" date:"+date+" hours: "+hours);
			
			DateFormat df =new SimpleDateFormat("dd-MM-yyyy");
			String newdate = df.format(date);
			System.out.println("String date = "+newdate);
			
			/*This need to be obtained from the database.
			 * or retreived for the session variable..
			 * i have assumed it to be 1 for now*/
			empID = 1;
			
			String sql="insert into timesheet(project_num,task_name,emp_id,work_date,no_of_hours)values("+won+",'"+taskname+"',"+empID+",'"+newdate+"',"+hours+");";               
			
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
			//return autoIncKeyFromApi;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	
		return "success";
	}
	
	public static String addApproval(String taskname,String status,int won,Date date) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();

			System.out.println("inside addApproval----- ;;;;; ");
			
			DateFormat df =new SimpleDateFormat("dd-MM-yyyy");
			String newdate = df.format(date);
			System.out.println("String date = "+newdate);
			
			/*This need to be obtained from the database.
			 * or retreived for the session variable..
			 * i have assumed it to be 1 for now*/
			empID = 1;
			
			int timeSheetID=0;
			int managerID=0;
			
			System.out.println("won :"+won+" taskName :"+taskname+" empID :"+empID);
			
			timeSheetID = TimeSheetService.findTimeSheetID("where project_num = "+won+" and emp_id = "+empID+" and work_date = '"+newdate+"' and task_name = '"+ taskname+"'");
			System.out.println("Time Sheet ID = "+timeSheetID);
			/*System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("temp1.size() = " + temp1.size());
			for(int i=0;i<temp1.size();i++){
				timeSheetID = temp1.get(i).getTimeSheetID();
				System.out.println("timeSheetID = "+timeSheetID);
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");*/
			
			System.out.println("emp ID : "+empID);
			managerID = EmployeeService.findManagerID("where emp_id = "+empID);
			System.out.println("managet id = "+managerID);
			/*for(int i=1;i<temp2.size();i++){
				managerID = temp2.get(i).getManagerID();
				System.out.println("ManagerID = "+temp2.get(i).getManagerID());
			}*/
						
			System.out.println("TimeSheetID : "+timeSheetID+" ManagerID : "+managerID+" Status : "+status);
			String sql="insert into Approval(timesheet_id,manager_id)values("+timeSheetID+","+managerID+");";               
			
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
			//return autoIncKeyFromApi;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	
		return "success";
	}
}
