package iiitb.timesheet.action;

import iiitb.timesheet.model.AssignedEmployees;
import iiitb.timesheet.model.Assignment;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.Project;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.service.ProjectService;
import iiitb.timesheet.service.UserAccountService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{

	private String function;
	private ArrayList<Project> projectlist = new ArrayList<Project>();
	private ArrayList<AssignedEmployees> otheremp = new ArrayList<AssignedEmployees>();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<AssignedEmployees> getOtheremp() {
		return otheremp;
	}

	public void setOtheremp(ArrayList<AssignedEmployees> otheremp) {
		this.otheremp = otheremp;
	}

	public ArrayList<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(ArrayList<Project> projectlist) {
		this.projectlist = projectlist;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String execute()
	{
		String val="";

		System.out.println("inside execute -- > "+function);

		if(function.equalsIgnoreCase("SubmitTimsheet")){
			val="SubmitTimesheet";
		}

		if(function.equalsIgnoreCase("MyProject")){
			int empid=1;
			int pid = AssignmentService.findProjectID("where emp_id = "+empid);
			projectlist = ProjectService.findProjectDetails("where pid = "+pid,empid);

			/* getting the other employees of the project */
			otheremp = AssignmentService.getOtherEmp(pid);
			System.out.println("otheremp size :"+otheremp.size());











			/*ArrayList<Employee> temp = EmployeeService.findEmployeeDetails("where emp_id = "+empid);
				System.out.println("Temp size :"+temp.size());
				String fname = temp.get(0).getFirstname();
				fname = fname.concat(" ");
				String lname = temp.get(0).getLastname();
				name = fname.concat(lname);*/
		

		val="MyProject";
	}
	if(function.equalsIgnoreCase("PasswordManagement")){
		val="PasswordManagement";
	}

	System.out.println("Val = " +val);

	return val;
}	
}
