package iiitb.timesheet.action;

import iiitb.timesheet.model.Report;
import iiitb.timesheet.service.ReportService;

import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReportAction extends ActionSupport{

	
	private String reportname;
	ArrayList<Report> reports=new ArrayList<Report>();
	private Date currentDate;
	private String employee_name;
	
	
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
		
		ReportService rp=new ReportService();
		
		
		if(reportname.startsWith("Timesheet")){
			
		}
		if(reportname.startsWith("Project")){
			
		}
		if(reportname.startsWith("Employee")){
			
		}
		
		System.out.println(reportname);
		
		reports=rp.getReports();
		setCurrentDate(new Date());
		
		System.out.println(new Date());
		employee_name="Suhas Dev";
		
		return SUCCESS;
	}
	
}
