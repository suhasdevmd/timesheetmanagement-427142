package iiitb.timesheet.action;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;
import iiitb.timesheet.model.*;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.ProjectService;

public class TimeSheetAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int won;
	private String projectname;
	private String taskname;
	private Date date;
	private float hrs;
	private String status;
	private String commandButton = "";
	
	public float getHrs() {
		return hrs;
	}

	public void setHrs(float hrs) {
		this.hrs = hrs;
	}
	
	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getToday() {
		return new Date();
	}
	
	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String execute() {
		
		int empid = 1;
		int pid = 6;
		System.out.println("In TimeSheetAction.java --- execute()");
		System.out.println("button :" + this.commandButton);
		
		if(this.commandButton.equals("Refresh")){			
			projectname = ProjectService.findProjectName("where project_num =" + won);
			taskname = AssignmentService.findTaskName("where emp_id = "+empid+" and pid = "+pid);
			status = "pending";
			
			return "refresh-success";
		}
		else if(this.commandButton.equals("Submit")){
			
			this.taskname = AssignmentService.findTaskName("where emp_id = "+empid+" and pid = "+pid);
			String timeSheetReturnValue = InsertIntoDB.addTimeSheet(won, taskname, date, hrs);
			System.out.println(timeSheetReturnValue);
		
			String approvalReturnValue = InsertIntoDB.addApproval(taskname, status, won, date);
			System.out.println(approvalReturnValue);
			
			if(timeSheetReturnValue.equals("success") && approvalReturnValue.equals("success")){
				return "success";
			}
			else
				return "error";
		}
		else 
			return "error";
	}
		
}
	

