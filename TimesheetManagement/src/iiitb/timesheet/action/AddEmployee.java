package iiitb.timesheet.action;

import java.util.ArrayList;


import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.util.MyLog;
import com.opensymphony.xwork2.ActionSupport;

import iiitb.timesheet.model.Employee;


public class AddEmployee extends ActionSupport  {

	private String firstname="";
	private String lastname="";
	private String email="";
	private int phone_num=0;
	private String join_date;
	private String role_name;
    private int emp_id;
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public String execute() {
		//MyLog.log("in AddEmployee.execute() with  = ");
		//if (this.firstname.isEmpty()) {
			//return "initial";
		//}
		System.out.println(emp_id);
		Employee employee = new Employee();
		EmployeeService employeeService = new EmployeeService();
		//employee.setEmp_id(emp_id);
		employee.setFirstname(firstname);
		System.out.println(employee.getFirstname());
		employee.setLastname(lastname);
		employee.setEmail(email);
		employee.setPhone_num(phone_num);
		employee.setJoin_date(EmployeeService.getDate(join_date));
		employee.setRole_name(role_name);
		employeeService.insert(employee);
		
		
		this.employees.clear();
		this.employees = EmployeeService.getEmployees("");
		employee=EmployeeService.getEmployee("where phone_num=" + employee.getPhone_num());
		employeeService.insertIntoUserAcc(employee);
		return "success";
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
}

