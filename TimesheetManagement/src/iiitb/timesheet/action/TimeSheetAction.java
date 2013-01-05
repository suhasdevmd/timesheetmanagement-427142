package iiitb.timesheet.action;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;
import iiitb.timesheet.model.*;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.ProjectService;
import iiitb.timesheet.service.TimeSheetService;

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
	ArrayList<TimesheetEmployee> viewtimesheet = new ArrayList<TimesheetEmployee>();
	
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
	
	public ArrayList<TimesheetEmployee> getViewtimesheet() {
		return viewtimesheet;
	}

	public void setViewtimesheet(ArrayList<TimesheetEmployee> viewtimesheet) {
		this.viewtimesheet = viewtimesheet;
	}

	public String execute() {
		
		int empid = 1;
		int pid = 6;
		System.out.println("In TimeSheetAction.java --- execute()");
		System.out.println("button :" + this.commandButton);
		
		if(this.commandButton.equals("Refresh")){			
			System.out.println("button :"+this.commandButton);
			projectname = ProjectService.findProjectName("where project_num =" + won);
			taskname = AssignmentService.findTaskName("where emp_id = "+empid+" and pid = "+pid);
			status = "pending";
			viewtimesheet.clear();
			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+empid+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num;");
			
			return "refresh-success";
		}
		else if(this.commandButton.equals("Submit")){
			
			this.taskname = AssignmentService.findTaskName("where emp_id = "+empid+" and pid = "+pid);
			String timeSheetReturnValue = InsertIntoDB.addTimeSheet(won, taskname, date, hrs);
			System.out.println(timeSheetReturnValue);
		
			String approvalReturnValue = InsertIntoDB.addApproval(taskname, status, won, date);
			System.out.println(approvalReturnValue);
			viewtimesheet.clear();
			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+empid+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num;");
			
			if(timeSheetReturnValue.equals("success") && approvalReturnValue.equals("success")){
				projectname = "Project Name";
				taskname = "Task Name";
				status = "Pending...";
				commandButton="success";
				hrs=0;
				return "success";
			}
			else
				return "error";
		}
		else 
			return "error";
	}	
}
	

