package iiitb.timesheet.model;

public class Timesheet {

	int timesheet_id;
	int project_num;
	String task_name;
	int emp_id;
	String work_date;
	float no_of_hours;
	
	
	public int getTimesheet_id() {
		return timesheet_id;
	}
	public void setTimesheet_id(int timesheet_id) {
		this.timesheet_id = timesheet_id;
	}
	
	
	
	
	public int getProject_num() {
		return project_num;
	}
	public void setProject_num(int project_num) {
		this.project_num = project_num;
	}
	
	
	
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public float getNo_of_hours() {
		return no_of_hours;
	}
	public void setNo_of_hours(float no_of_hours) {
		this.no_of_hours = no_of_hours;
	}
	
	
	
	
	
	
}
