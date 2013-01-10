package iiitb.timesheet.action;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.SendMail;
import iiitb.timesheet.model.UserAccount;
import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.service.UserAccountService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;


public class AddEmployee extends ActionSupport  {

	private String firstname="";
	private String lastname="";
	private String email="";
	private long phone_num=0;
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



		Boolean val = EmployeeService.checkForDuplicateEmp(employee);
		System.out.println("value is"+val);


		if(val==true) {

			employeeService.insert(employee);


			this.employees.clear();
			this.employees = EmployeeService.getEmployees("");
			employee=EmployeeService.getEmployee("where phone_num=" + employee.getPhone_num());
			employeeService.insertIntoUserAcc(employee);
			
			
			
			System.out.println("===================Ashwin edit===================");
            
            System.out.println("Employee ID : "+employee.getEmp_id());
            ArrayList<Employee> temp = EmployeeService.findEmployeeDetails(" where emp_id = "+employee.getEmp_id());
            for (int j = 0; j < temp.size(); j++) {
                    email = temp.get(j).getEmail();
                    System.out.println("Email : "+email);
            }
            UserAccount ua = new UserAccount();
            ua = UserAccountService.findUsernamePassword(" where emp_id = "+emp_id);

            System.out.println("UserName : "+ua.getUsername()+"\n Password : "+ua.getPassword()+"\n\n Please Login and Change Your password at the earliest.\n Thank You.");
            String subject = "User Credentials";
            String body = "Dear "+firstname+" "+lastname+",\n\n\tYour Employee Deatails have been added.\n\tUserName : "+ua.getUsername()+"\n\tPassword : "+ua.getPassword()+"\n\nPlease Login and change your password at the earliest.\n\tThank You.";

            try {
                    SendMail.sendTextMail(email, subject, body);
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
			
			
			return "success";

		}else {
			addActionError(getText("Employee already exists!!"));
			return "duplicate";
		}
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

