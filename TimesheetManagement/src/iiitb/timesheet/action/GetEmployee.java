package iiitb.timesheet.action;




import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.service.EmployeeService;

public class GetEmployee extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname="";
	private String lastname="";
	private String email="";
	private long phone_num=0;
	private String join_date;
	private int manager_id=0;
	private int role_id=0;
	private String role_name;
	private int emp_id;
	//private List<String> roles;
	//HttpServletRequest request;
	//Employee employee = new Employee();
	
	public String execute() {
		Employee employee = new Employee();

		employee = EmployeeService.getEmployee("where emp_id=" + emp_id);
		firstname = employee.getFirstname();
		lastname = employee.getLastname();
		email = employee.getEmail();
		phone_num = employee.getPhone_num();
		join_date = employee.getJoin_date();
		role_name = employee.getRole_name();
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

	public long getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
	

	

}
