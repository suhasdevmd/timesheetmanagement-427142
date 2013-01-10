package iiitb.timesheet.action;

import iiitb.timesheet.service.AssignEmpService;
import iiitb.timesheet.service.ManagerService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AssignEmpAction extends ActionSupport{

	private String project1;
	private String task1;
	ArrayList<String> employees=new ArrayList<String>();
	ArrayList<String> emp=new ArrayList<String>();
	ArrayList<String> project=new ArrayList<String>();
	ArrayList<String> task=new ArrayList<String>();
	
	
	
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
	public String getProject1() {
		return project1;
	}
	public void setProject1(String project1) {
		this.project1 = project1;
	}
	public String getTask1() {
		return task1;
	}
	public void setTask1(String task1) {
		this.task1 = task1;
	}
	public ArrayList<String> getEmp() {
		return emp;
	}
	public void setEmp(ArrayList<String> emp) {
		this.emp = emp;
	}


	
	
	
	public ArrayList<String> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<String> employees) {
		this.employees = employees;
	}
	
	
	public String execute(){
		
		System.out.println(project1);
		System.out.println(task1);

		ManagerService ms=new ManagerService();
		
		AssignEmpService as=new AssignEmpService();
		System.out.println("-------->"+as.getProjectID(project1));
		
		int pid=as.getProjectID(project1);
		int stat = 0;
		
		for(int i=0;i<employees.size();i++){
			System.out.println(employees.get(i));
			int emp_id=as.getEmployeeID(employees.get(i));
			stat=as.addAssignment(pid, task1, emp_id);
		}
		
		
		
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

		
		if(stat==0){
			addActionError(getText("Project assignment failed !"));
		}else{
			addActionMessage(getText("Project assignment successful !"));
		}
		
		
		return SUCCESS;
	}
	
	
}
