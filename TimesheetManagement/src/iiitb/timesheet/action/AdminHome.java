package iiitb.timesheet.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.TimesheetEmployee;

import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.EmployeeService;
import iiitb.timesheet.service.ProjectService;
import iiitb.timesheet.service.TimeSheetService;
public class AdminHome extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String function;
	String val;
	Map session = ActionContext.getContext().getSession();
	private int won;
    private String projectname;
    private String taskname;
    private String status;
    private int employee_id;
    ArrayList<TimesheetEmployee> viewtimesheet = new ArrayList<TimesheetEmployee>();
	
	
	
	
	public ArrayList<TimesheetEmployee> getViewtimesheet() {
		return viewtimesheet;
	}
	public void setViewtimesheet(ArrayList<TimesheetEmployee> viewtimesheet) {
		this.viewtimesheet = viewtimesheet;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	private ArrayList<Employee> employees = 
		new ArrayList<Employee>();
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public String execute() throws Exception {
		
		
		ArrayList<Employee> temp = (ArrayList<Employee>) session.get("EmployeeDetails");
		employee_id=temp.get(0).getEmp_id();
		
		
		if(function.equalsIgnoreCase("SubmitTimesheet")){
			
			
			
			
			System.out.println("ss the emp -id : "+employee_id);

            int project_id = AssignmentService.findProjectID(" where emp_id ="+employee_id);
            won = AssignmentService.findProjectNum(" where pid = "+project_id);

            projectname = ProjectService.findProjectName("where project_num = '"+won+"'");
            taskname = AssignmentService.findTaskName("where emp_id = '"+employee_id+"' and pid = '"+project_id+"'");
            status = "pending";
			
			
			
			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num;");
			
			System.out.println("--?? "+viewtimesheet.size());
			
			
			
			
			val="SubmitTimesheet";
		}
		if(function.equalsIgnoreCase("AddUpdateEmployee")){
			this.employees = EmployeeService.getEmployees("");
			val="AddUpdateEmployee";
		}
	return val;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}


}
