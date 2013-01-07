package iiitb.timesheet.action;

import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.service.ReportService;

import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport{

	
	ArrayList<ProjectReport> projectReport=new ArrayList<ProjectReport>();
	private Date currentDate;
	
	
	public ArrayList<ProjectReport> getProjectReport() {
		return projectReport;
	}


	public void setProjectReport(ArrayList<ProjectReport> projectReport) {
		this.projectReport = projectReport;
	}


	public Date getCurrentDate() {
		return currentDate;
	}


	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}


	public String execute(){
		
		
		ReportService rp=new ReportService();
		projectReport=rp.getProjectReport();
		
		System.out.println("Project rep size suhas : "+projectReport.size());
		//val="Project";
		setCurrentDate(new Date());
		
		return SUCCESS;
	}
	
	
}
