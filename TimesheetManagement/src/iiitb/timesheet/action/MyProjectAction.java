package iiitb.timesheet.action;

import com.opensymphony.xwork2.ActionSupport;

public class MyProjectAction extends ActionSupport{
	
	private String commandButton = "";

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	public String execute(){
		if(this.commandButton.equals("Enter Time Sheet For Today")){
			System.out.println("button pressed is :" +this.commandButton);
			return "timesheet-success";
		}
		if(this.commandButton.equals("Change Password")){
			System.out.println("button pressed is :" +this.commandButton);
			return "passwordchange";
		}
		return "";
	}
}
