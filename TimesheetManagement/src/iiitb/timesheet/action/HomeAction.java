package iiitb.timesheet.action;

import iiitb.timesheet.model.Employee;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	Map session=ActionContext.getContext().getSession();
	String role_name;
	ArrayList<Employee> employeeList=new ArrayList<Employee>();



	public String execute(){

		String val="";
		employeeList=(ArrayList<Employee>)session.get("EmployeeDetails");


		try {
			if(employeeList!=null){
				role_name=employeeList.get(0).getRole_name();



				System.out.println("inside home ");

				if(role_name.equalsIgnoreCase("admin")){

					val="admin";
				}
				else if(role_name.equalsIgnoreCase("manager")){

					val="manager";
				}
				else if(role_name.equalsIgnoreCase("team_member")){

					val="team_member";
				}
			}
			else{

				val="client";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		System.out.println("test role name : "+val);

		return val;
	}


}
