package iiitb.timesheet.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import iiitb.timesheet.model.Employee;

import iiitb.timesheet.service.EmployeeService;
public class AdminHome extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String function;
	String val;
	private ArrayList<Employee> employees = 
		new ArrayList<Employee>();
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public String execute() throws Exception {
		if(function.equalsIgnoreCase("SubmitTimesheet")){
			val="SubmitTimesheet";
		}
		if(function.equalsIgnoreCase("AddUpdateEmployee")){
			this.employees = EmployeeService.getEmployees("");
			val="AddUpdateEmployee";
		}
	return val;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}


}
