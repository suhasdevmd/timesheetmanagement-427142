package iiitb.timesheet.service;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.SendMail;
import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.model.TimesheetEmployee;
import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ApproveTimesheetService {
	
	
	public void updateStatus(String timesheet_id,String status){
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			
			String sql="update approval set status="+"'"+status+"' where timesheet_id="+"'"+timesheet_id+"' ;";
			
			System.out.println("update quert : "+sql);
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			
			// sending mail 
			
			
			
			ArrayList<TimesheetEmployee> temp = TimeSheetService.findTimeSheet(" where t.timesheet_id = '"+timesheet_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num;");
            for(int i =0;i<temp.size();i++){
                    System.out.println("Project Name :"+temp.get(i).getProject_name());
                    
                    String subject = "Your Time Sheet Status Updated. Project Name : "+temp.get(i).getProject_name()+" Date : "+temp.get(i).getWork_date();
                    System.out.println(subject);
                    
                    System.out.println("Employee id = "+temp.get(i).getEmp_id());
                    
                    String body = "Your TimeSheet has Been updated to "+status+"\n \n Project Number : "+temp.get(i).getProject_num()+"\n Project Name : "+temp.get(i).getProject_name()+"\n Dated : "+temp.get(i).getWork_date()+"\n Worked Hours : "+temp.get(i).getNo_of_hours();
                    System.out.println(body);
                    
                    String email = "";
                    int empid = temp.get(i).getEmp_id();
                    System.out.println("Employee ID : "+empid);
                    
                    ArrayList<Employee> temp1 = EmployeeService.findEmployeeDetails(" where emp_id = "+empid);
                    for (int j = 0; j < temp1.size(); j++) {
                            email = temp1.get(j).getEmail();
                            System.out.println("Email = "+email);
                    }
                    
                    try {
                            SendMail.sendTextMail(email, subject, body);
                    } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
            }

			
			
			
			
			
			if (stmt != null) 
				stmt.close();
			con.close();
			//returns the patient id
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
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
	
	
	
	
	public ArrayList<Timesheet> getEmployeeTimesheets(int emp_id,int manager_id){
		ArrayList<Timesheet> timesheets=new ArrayList<Timesheet>();
		
		
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			/*query="select project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' ";*/
			
			/*query="select t.timesheet_id,project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' and t.emp_id="+"'"+emp_id+"' ;";*/
			
			query="select t.timesheet_id,project_num,task_name,emp_id,work_date"+
			",no_of_hours from timesheet t,approval a where "+
			"t.timesheet_id=a.timesheet_id and a.status='pending' and t.emp_id="+"'"+emp_id+"' and a.manager_id="+"'"+manager_id+"';";
			
			
			
			
			System.out.println("??? - > "+query);
			
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
