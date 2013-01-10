package iiitb.timesheet.action;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.InsertIntoDB;
import iiitb.timesheet.model.TimesheetEmployee;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.TimeSheetService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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


	Map session = ActionContext.getContext().getSession();
	private int employee_id;
	private int project_id;



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

		ArrayList<Employee> empdetails = (ArrayList<Employee>) session.get("EmployeeDetails");

		for(int i=0;i<empdetails.size();i++){
			employee_id = empdetails.get(i).getEmp_id();
			System.out.println("employee id obtained from the session is :" + employee_id);
		}



		project_id = AssignmentService.findProjectID(" where emp_id ="+employee_id);
		won = AssignmentService.findProjectNum(" where pid = "+project_id);

		if(won == 0){
			addActionError("You are not assigned to any project!!");
			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");
			return "success";
		}
		if(this.commandButton.equals("Submit")){



			System.out.println("------------+++++++++++++=================");
			DateFormat df =new SimpleDateFormat("dd-MM-yyyy");
			String date1 = df.format(date);
			System.out.println("date from jsp : "+date1);

			Date date2 = new Date();
			String newdate = " ";
			newdate = df.format(date2);
			System.out.println("new date : "+date2);
			System.out.println("------------+++++++++++++=================");

			if(!date1.equalsIgnoreCase(newdate)){
				addActionError("Cannot submit Timesheet for a future date.");
				viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");
				return "success";
			}

			this.taskname = AssignmentService.findTaskName("where emp_id = "+employee_id+" and pid = "+project_id);
			if(hrs <= 0 || hrs > 9){
				addActionError("Invalid entry for the field No. of Hours");
				viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");
				return "success";
			}
			String timeSheetReturnValue = InsertIntoDB.addTimeSheet(won, taskname, date, hrs);
			System.out.println(timeSheetReturnValue);

			if(timeSheetReturnValue.equals("actionMessage")){
				addActionError("Cannot submit another timesheet today");
				viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");
				return "success";
			}

			String approvalReturnValue = InsertIntoDB.addApproval(taskname, status, won, date);
			System.out.println(approvalReturnValue);

			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");

			if(timeSheetReturnValue.equals("success") && approvalReturnValue.equals("success")){
				addActionMessage("Timesheet entry added successfully.");
				return "success";
			}
			else{
				addActionError("Inserting into Database Failed.");
				return "success";
			}
		}
		else 
			return "error";
	}	
}


