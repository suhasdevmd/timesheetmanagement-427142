package iiitb.timesheet.action;

import iiitb.timesheet.model.Client;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.service.UserAccountService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordManagementAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oldpass;
	private String newpass;
	private String newpassre;

	Map session = ActionContext.getContext().getSession();
	private int employee_id;
	private String role_name;
	private int client_id;


	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getNewpassre() {
		return newpassre;
	}
	public void setNewpassre(String newpassre) {
		this.newpassre = newpassre;
	}

	public String execute() {

		/*int empid = 1;
		int clientid = 1;
		String role = "member";

		// currpass is the pass currently stored in DB
		String currpass = UserAccountService.findOldPassword(" where emp_id = "+empid);

		if(oldpass.equals(currpass) && newpass.equals(newpassre)){
			if(role.equals("admin") || role.equals("manager") || role.equals("member")){
				UserAccountService.updatePasswordUserAccount("where emp_id ="+empid, newpass);
				System.out.println("password successfully updated !!");
				return "success";
			}
			else {
				UserAccountService.updatePasswordClient("where client_id ="+clientid, newpass);
				System.out.println("password successfully updated !!");
				return "success";
			}

		}
		else {
			addActionError(getText("error.password"));
			return "error";
		}
		 */


		@SuppressWarnings("unchecked")
		ArrayList<Employee> empdetails = (ArrayList<Employee>) session.get("EmployeeDetails");

		if(empdetails!=null){
		for(int i=0;i<empdetails.size();i++){
			employee_id = empdetails.get(i).getEmp_id();
			role_name = empdetails.get(i).getRole_name();
			System.out.println("employee id obtained from the session is :" + employee_id);
		}}
		//int empid = 1;
		//int clientid = 1;
		//String role = "member";

		ArrayList<Client> clientdetails = (ArrayList<Client>) session.get("ClientDetails");

		if(clientdetails!=null){
			for(int i=0;i<clientdetails.size();i++){
				client_id = clientdetails.get(i).getClient_id();

				System.out.println("client id obtained from the session is :" + client_id);
			}

		}
		// currpass is the pass currently stored in DB
		String currpass = UserAccountService.findOldPassword(" where emp_id = "+employee_id);

		if(oldpass.equals(currpass) && newpass.equals(newpassre)){
			if(role_name.equalsIgnoreCase("admin") || role_name.equalsIgnoreCase("manager") || role_name.equalsIgnoreCase("team_member")){
				UserAccountService.updatePasswordUserAccount("where emp_id ="+employee_id, newpass);
				addActionMessage(getText("password successfully updated !!"));
				return "success";
			}
			else {
				UserAccountService.updatePasswordClient("where client_id ="+client_id, newpass);
				addActionMessage(getText("password successfully updated !!"));
				return "success";
			}

		}
		else {
			addActionError(getText("error.password"));
			return "error";
		}



	}
}
