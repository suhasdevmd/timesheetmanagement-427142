package iiitb.timesheet.service;

import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.model.Report;
import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReportService {
	
	
	public ArrayList<Report> getReports(){
		
		ArrayList<Report> reports=new ArrayList<Report>();
		

		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			/*query="select project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' ";*/
			
			query="select t.work_date,t.emp_id,a.manager_id,a.status"+
			" from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id";
			
			
			
			rs=DB.readFromDB(query, con);
			
			System.out.println("sssssss report"+query);
			
			while(rs.next()){
				
				
				Report report=new Report();
				report.setWork_date(rs.getString("work_date"));
				report.setEmp_name(getEmpName(rs.getString("emp_id")));
				report.setApprover(getEmpName(rs.getString("manager_id")));
				report.setStatus(rs.getString("status"));
				
				reports.add(report);
			
				
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return reports;
		
	}
	

	public String getEmpName(String emp_id){
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
	
	
	
	
	public ArrayList<ProjectReport> getProjectReport(){
		ArrayList<ProjectReport> pReport=new ArrayList<ProjectReport>();
		

		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			/*query="select project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' ";*/
			
			query="select p.project_num,p.project_name,p.description,p.startdate,p.enddate,e.firstname,e.lastname "+
			" from project p, employee e,assignment a where p.pid=a.pid and e.emp_id=a.emp_id;";
			
			
			
			rs=DB.readFromDB(query, con);
			
			System.out.println("sssssss report "+query);
			
			while(rs.next()){
				
				
				ProjectReport report=new ProjectReport();
				report.setProject_num(rs.getInt("project_num"));
				System.out.println(rs.getInt("project_num"));
				report.setProject_name(rs.getString("project_name"));
				report.setDescription(rs.getString("description"));
				report.setStartdate(rs.getString("startdate"));
				report.setEnddate(rs.getString("enddate"));
				report.setFirstname(rs.getString("firstname"));
				report.setLastname(rs.getString("lastname"));
				
				pReport.add(report);
			
				
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return pReport;
	}
	
	
	
	
	
	
	
}
