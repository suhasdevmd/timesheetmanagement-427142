package iiitb.timesheet.action;

import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.model.Report;
import iiitb.timesheet.service.ReportService;

import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReportAction extends ActionSupport{

	
	private String reportname;
	ArrayList<Report> reports=new ArrayList<Report>();
	ArrayList<ProjectReport> projectReport=new ArrayList<ProjectReport>();
	private Date currentDate;
	private String employee_name;
	

	
	public ArrayList<ProjectReport> getProjectReport() {
		return projectReport;
	}
	public void setProjectReport(ArrayList<ProjectReport> projectReport) {
		this.projectReport = projectReport;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public ArrayList<Report> getReports() {
		return reports;
	}
	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}	
	
	public String getReportname() {
		return reportname;
	}
	public void setReportname(String reportname) {
		this.reportname = reportname;
	}




	public String execute(){
		
		
		String val="error";
		ReportService rp=new ReportService();
		
		
		if(reportname.startsWith("Timesheet")){
		
			System.out.println(reportname);
			
			reports=rp.getReports();
			
			val="Timesheet";
		}
		if(reportname.startsWith("Project")){
			
			
			projectReport=rp.getProjectReport();
			
			System.out.println("Project rep size suhas : "+projectReport.size());
			val="Project";
		}
		if(reportname.startsWith("Employee")){
			
			
			val="Employee";
		}
		
		
		setCurrentDate(new Date());
		
		System.out.println(new Date());
		
		
		
		// ---> ******** Employee name needs to be retrieved from session ********* ////
		
		employee_name="Suhas Dev";
		
		return val;
	}
	
}
