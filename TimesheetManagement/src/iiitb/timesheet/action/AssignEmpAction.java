package iiitb.timesheet.action;

import iiitb.timesheet.service.AssignEmpService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AssignEmpAction extends ActionSupport{

	private String project;
	private String task;
	ArrayList<String> employees=new ArrayList<String>();
	
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public ArrayList<String> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<String> employees) {
		this.employees = employees;
	}
	
	
	public String execute(){
		
		System.out.println(project);
		System.out.println(task);

		
		AssignEmpService as=new AssignEmpService();
		System.out.println("-------->"+as.getProjectID(project));
		
		int pid=as.getProjectID(project);
		
		for(int i=0;i<employees.size();i++){
			System.out.println(employees.get(i));
			int emp_id=as.getEmployeeID(employees.get(i));
			as.addAssignment(pid, task, emp_id);
		}
		
		return SUCCESS;
	}
	
	
}
