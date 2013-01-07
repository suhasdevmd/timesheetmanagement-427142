package iiitb.timesheet.action;

import iiitb.timesheet.model.AssignedEmployees;
import iiitb.timesheet.model.Project;
import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.ManagerService;
import iiitb.timesheet.service.ProjectService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport{

	private String function;
	ArrayList<String> project=new ArrayList<String>();
	ArrayList<String> task=new ArrayList<String>();
	ArrayList<String> emp=new ArrayList<String>();
	ArrayList<Timesheet> timesheets=new ArrayList<Timesheet>();
	ArrayList<String> clients=new ArrayList<String>();
	
	private ArrayList<Project> projectlist = new ArrayList<Project>();
	private ArrayList<AssignedEmployees> otheremp = new ArrayList<AssignedEmployees>();
	
	
	public ArrayList<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(ArrayList<Project> projectlist) {
		this.projectlist = projectlist;
	}

	public ArrayList<AssignedEmployees> getOtheremp() {
		return otheremp;
	}

	public void setOtheremp(ArrayList<AssignedEmployees> otheremp) {
		this.otheremp = otheremp;
	}

	public ArrayList<String> getClients() {
		return clients;
	}

	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
	}

	public ArrayList<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(ArrayList<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public ArrayList<String> getEmp() {
		return emp;
	}

	public void setEmp(ArrayList<String> emp) {
		this.emp = emp;
	}

	public ArrayList<String> getProject() {
		return project;
	}

	public void setProject(ArrayList<String> project) {
		this.project = project;
	}

	public ArrayList<String> getTask() {
		return task;
	}

	public void setTask(ArrayList<String> task) {
		this.task = task;
	}

	

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	public String execute()
	{
		String val="Manager";
		ManagerService ms=new ManagerService();
		
		System.out.println("---------------------------->");
		System.out.println("inside execute -- > "+function);
		
		if(function.equalsIgnoreCase("SubmitTimesheet")){
			val="SubmitTimesheet";
		}
		if(function.equalsIgnoreCase("ApproveTimesheet")){
			val="ApproveTimesheet";
			
			// get the time sheets of all the employees
			timesheets=ms.getTimesheets();
			emp=ms.getEmployees();
			
		}
		if(function.equalsIgnoreCase("MyProject")){
			
			val="MyProject";
			
			int empid=1;
			int pid = AssignmentService.findProjectID("where emp_id = "+empid);
			projectlist = ProjectService.findProjectDetails("where pid = "+pid,empid);

			/* getting the other employees of the project */
			otheremp = AssignmentService.getOtherEmp(pid);
			System.out.println("otheremp size :"+otheremp.size());
		}
		if(function.equalsIgnoreCase("CreateProject")){
			
			//clients.add("Google");
			//clients.add("TCS");
			//clients.add("Yahoo");
			
			clients=ms.getClients();
			
			
			
			val="CreateProject";
		}
		if(function.equalsIgnoreCase("ViewReport")){
			val="ViewReport";
		}
		if(function.equalsIgnoreCase("AssignEmp")){
			
			
			
			// retrieve projects from database
			
			project=ms.getProjects();
			
			System.out.println("--- size : "+project.size());
			
			//project.add("Proj1");
			//project.add("Proj2");
			//project.add("Proj3");
			//project.add("Proj4");
			
			task.add("Requirement");
			task.add("Development");
			task.add("Testing");
			
			
			// retrieve employees from database
			
			//emp.add("Suhas Dev");
			//emp.add("John Rambo");
			//emp.add("James Bond");
			//emp.add("Tome cruise");
			//emp.add("Bruce Willis");
			emp=ms.getEmployees();
			
			val="AssignEmp";
		}
		
		if(function.equalsIgnoreCase("AddClient")){
			val="AddClient";
		}
		System.out.println("-------> suhas -->  "+val);
		
		return val;
	}
	
	
}
