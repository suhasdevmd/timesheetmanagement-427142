package iiitb.timesheet.action;

import iiitb.timesheet.model.AssignedEmployees;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.Project;
import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.model.TimesheetEmployee;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.ManagerService;
import iiitb.timesheet.service.ProjectService;
import iiitb.timesheet.service.TimeSheetService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport{

	private String function;
	ArrayList<String> project=new ArrayList<String>();
	ArrayList<String> task=new ArrayList<String>();
	ArrayList<String> emp=new ArrayList<String>();
	ArrayList<Timesheet> timesheets=new ArrayList<Timesheet>();
	ArrayList<String> clients=new ArrayList<String>();
	Map session=ActionContext.getContext().getSession();
	ArrayList<Employee> empDet=new ArrayList<Employee>();	
	private ArrayList<Project> projectlist = new ArrayList<Project>();
	private ArrayList<AssignedEmployees> otheremp = new ArrayList<AssignedEmployees>();
	ArrayList<TimesheetEmployee> viewtimesheet = new ArrayList<TimesheetEmployee>();


	private int won;
	private String projectname;
	private String taskname;
	private String status;
	private int employee_id;




	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public ArrayList<TimesheetEmployee> getViewtimesheet() {
		return viewtimesheet;
	}

	public void setViewtimesheet(ArrayList<TimesheetEmployee> viewtimesheet) {
		this.viewtimesheet = viewtimesheet;
	}

	public ArrayList<Employee> getEmpDet() {
		return empDet;
	}

	public void setEmpDet(ArrayList<Employee> empDet) {
		this.empDet = empDet;
	}

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


		empDet=(ArrayList<Employee>)session.get("EmployeeDetails");
		employee_id=empDet.get(0).getEmp_id();


		//int employee_id;
		if(function.equalsIgnoreCase("SubmitTimesheet")){


			System.out.println("ss the emp -id : "+employee_id);

			int project_id = AssignmentService.findProjectID(" where emp_id ="+employee_id);
			won = AssignmentService.findProjectNum(" where pid = "+project_id);

			projectname = ProjectService.findProjectName("where project_num = '"+won+"'");
			taskname = AssignmentService.findTaskName("where emp_id = '"+employee_id+"' and pid = '"+project_id+"'");
			status = "pending";



			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");

			System.out.println("--?? "+viewtimesheet.size());


			val="SubmitTimesheet";
		}
		if(function.equalsIgnoreCase("ApproveTimesheet")){
			val="ApproveTimesheet";

			// get the time sheets of all the employees



			int manager_id=empDet.get(0).getEmp_id();
			timesheets=ms.getTimesheets(manager_id);
			emp=ms.getEmployees();

		}
		if(function.equalsIgnoreCase("MyProject")){

			val="MyProject";

			//int empid=1;
			int pid = AssignmentService.findProjectID("where emp_id = "+employee_id);
			projectlist = ProjectService.findProjectDetails("where pid = "+pid,employee_id);



			/* getting the other employees of the project */
			otheremp = AssignmentService.getOtherEmp(pid);
			System.out.println("otheremp size :"+otheremp.size());

			if(projectlist == null && otheremp == null){
				addActionError("You are not assigned to any project");
				return "error";
			}


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
			emp=ms.getEmployeesFromDB();

			val="AssignEmp";
		}

		if(function.equalsIgnoreCase("AddClient")){
			val="AddClient";
		}
		
		
		if(function.equalsIgnoreCase("PasswordManagement")){
			val="PasswordManagement";
		}
		
		System.out.println("-------> suhas -->  "+val);

		return val;
	}


}
