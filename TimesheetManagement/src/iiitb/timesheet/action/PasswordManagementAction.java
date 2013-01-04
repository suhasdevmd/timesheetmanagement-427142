package iiitb.timesheet.action;

import iiitb.timesheet.service.UserAccountService;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordManagementAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oldpass;
	private String newpass;
	private String newpassre;
	
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
		
		int empid = 1;
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
		
	}
}
