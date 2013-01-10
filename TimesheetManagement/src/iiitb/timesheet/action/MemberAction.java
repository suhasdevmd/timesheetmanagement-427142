package iiitb.timesheet.action;

import iiitb.timesheet.model.AssignedEmployees;
import iiitb.timesheet.model.Employee;
import iiitb.timesheet.model.Project;
import iiitb.timesheet.model.TimesheetEmployee;
import iiitb.timesheet.service.AssignmentService;
import iiitb.timesheet.service.ProjectService;
import iiitb.timesheet.service.TimeSheetService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{

	private String function;
	private ArrayList<Project> projectlist = new ArrayList<Project>();
	private ArrayList<AssignedEmployees> otheremp = new ArrayList<AssignedEmployees>();
	ArrayList<TimesheetEmployee> viewtimesheet = new ArrayList<TimesheetEmployee>();
	private String name;
	
	private int won;
    private String projectname;
    private String taskname;
    private String status;
    Map session = ActionContext.getContext().getSession();
    private int employee_id;
	
	

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<AssignedEmployees> getOtheremp() {
		return otheremp;
	}

	public void setOtheremp(ArrayList<AssignedEmployees> otheremp) {
		this.otheremp = otheremp;
	}

	public ArrayList<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(ArrayList<Project> projectlist) {
		this.projectlist = projectlist;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String execute()
	{
		String val="";

		System.out.println("inside execute -- > "+function);

		ArrayList<Employee> temp = (ArrayList<Employee>) session.get("EmployeeDetails");

        for(int i=0;i<temp.size();i++){
                employee_id = temp.get(i).getEmp_id();
                System.out.println("employee id obtained from the session is :" + employee_id);
        }
		
		if(function.equalsIgnoreCase("SubmitTimsheet")){
			//int empid = 1;
			
			
			 
             //int empid = 1;
			
			System.out.println("ss the emp -id : "+employee_id);

             int project_id = AssignmentService.findProjectID(" where emp_id ="+employee_id);
             won = AssignmentService.findProjectNum(" where pid = "+project_id);

             projectname = ProjectService.findProjectName("where project_num = '"+won+"'");
             taskname = AssignmentService.findTaskName("where emp_id = '"+employee_id+"' and pid = '"+project_id+"'");
             status = "pending";
			
			
			
			viewtimesheet = TimeSheetService.findTimeSheet(" where t.emp_id ='"+employee_id+"' and a.timesheet_id = t.timesheet_id and p.project_num = t.project_num order by work_date DESC;");
			
			System.out.println("--?? "+viewtimesheet.size());
			
			val="SubmitTimesheet";
		}

		if(function.equalsIgnoreCase("MyProject")){
			//int empid=1;
			
			
			
			int pid = AssignmentService.findProjectID("where emp_id = "+employee_id);
			projectlist = ProjectService.findProjectDetails("where pid = "+pid,employee_id);

			/* getting the other employees of the project */
			otheremp = AssignmentService.getOtherEmp(pid);
			System.out.println("otheremp size :"+otheremp.size());

			/*ArrayList<Employee> temp = EmployeeService.findEmployeeDetails("where emp_id = "+empid);
				System.out.println("Temp size :"+temp.size());
				String fname = temp.get(0).getFirstname();
				fname = fname.concat(" ");
				String lname = temp.get(0).getLastname();
				name = fname.concat(lname);*/
			
			if(projectlist == null && otheremp == null){
				addActionError("You are not assigned to any project");
				return "error";
			}
		

		val="MyProject";
	}
	if(function.equalsIgnoreCase("PasswordManagement")){
		val="PasswordManagement";
	}

	System.out.println("Val = " +val);

	return val;
}

	public ArrayList<TimesheetEmployee> getViewtimesheet() {
		return viewtimesheet;
	}

	public void setViewtimesheet(ArrayList<TimesheetEmployee> viewtimesheet) {
		this.viewtimesheet = viewtimesheet;
	}	
}
