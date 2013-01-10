package iiitb.timesheet.action;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.service.LoginService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String username="";
	private String password="";
	private String commandButton="";
	private ArrayList<Employee> employees = 
		new ArrayList<Employee>();
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	private Map session;
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception {

		LoginService login = new LoginService();

		System.out.println("suhas1");
		
		
		if ( username.length() == 0 || password.length() == 0) {
			addActionError(getText("Invalid username/password combination"));

			return "error";
		}
		
		String usertype=login.AuthenticateUser(username, password);
		
		System.out.println("userrrrrrrrrrrrrrrrr "+usertype);
		
		if (usertype!=null) {
			Map session = ActionContext.getContext().getSession();
			session.put("login","true");
			session.put("username",username);
			Date today = new Date();
            DateFormat df =new SimpleDateFormat("dd-MM-yyyy");
            String newdate = df.format(today);
            session.put("todayDate", newdate);
			//if(usertype == "admin") {
			this.employees.clear();
			this.employees = EmployeeService.getEmployees("");
			System.out.println("sdev : - > "+usertype);
			return usertype;
			//}
			//return usertype;
		} 
		
		
		
		
		
		addActionError(getText("Your login attempt was not successful. Please try again"));
		return "error";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
