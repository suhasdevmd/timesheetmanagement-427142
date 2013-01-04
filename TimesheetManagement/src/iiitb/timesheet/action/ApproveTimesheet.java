package iiitb.timesheet.action;

import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.service.ApproveTimesheetService;
import iiitb.timesheet.service.ManagerService;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ApproveTimesheet extends ActionSupport{

	private List<String> time=null;
	private String buttonName;
	private String employeename;
	ArrayList<Timesheet> timesheets=new ArrayList<Timesheet>();
	ApproveTimesheetService ats=new ApproveTimesheetService();
	ManagerService mg=new ManagerService();
	ArrayList<String> emp=new ArrayList<String>();
	//ArrayList<String> time=new ArrayList<String>;


	public ArrayList<String> getEmp() {
		return emp;
	}



	public void setEmp(ArrayList<String> emp) {
		this.emp = emp;
	}



	public ArrayList<Timesheet> getTimesheets() {
		return timesheets;
	}



	public void setTimesheets(ArrayList<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}



	public String getEmployeename() {
		return employeename;
	}



	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}



	public String getButtonName() {
		return buttonName;
	}



	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}



	public List<String> getTime() {
		return time;
	}



	public void setTime(List<String> time) {
		this.time = time;
	}



	public String execute(){
		
		
		

		if(buttonName.startsWith("Approve")){

			System.out.println("Approve");
			if(time!=null){
				System.out.println("dev - "+time.size());
				for(int i=0;i<time.size();i++){
					System.out.println(time.get(i));
					ats.updateStatus(time.get(i), "Approved");
				}
			}
			
			
			
			timesheets.clear();
			timesheets=mg.getTimesheets();
			emp=mg.getEmployees();
			
			
			
			return SUCCESS;
		}
		else if(buttonName.startsWith("Reject")){

			System.out.println("Reject");
			
			if(time!=null){
				System.out.println("dev - "+time.size());
				for(int i=0;i<time.size();i++){
					System.out.println(time.get(i));
					ats.updateStatus(time.get(i), "Rejected");
				}
			}
			
			
			
			timesheets.clear();
			timesheets=mg.getTimesheets();
			emp=mg.getEmployees();
			return SUCCESS;
		}
		else if(buttonName.startsWith("Search")){

			System.out.println("Search timesheet");
			
			System.out.println("Selected name"+employeename);
			System.out.println("Emp id : "+ats.getEmployeeID(employeename));
			
			
			// get the timesheets for the particular employee
			timesheets.clear();
			timesheets=ats.getEmployeeTimesheets(ats.getEmployeeID(employeename));
			
			emp=mg.getEmployees();
			
			
			
			
			return SUCCESS;
		}


		

		return ERROR;
	}

}
