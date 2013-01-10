package iiitb.timesheet.action;

import iiitb.timesheet.model.Client;
import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.model.Report;
import iiitb.timesheet.service.ReportService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
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
			if(reports!=null){
				reports=rp.getReports();
			}
			val="Timesheet";
		}
		if(reportname.startsWith("Project")){

			Map session=ActionContext.getContext().getSession();
			ArrayList<Client> clientdet=(ArrayList<Client>)session.get("ClientDetails");

			/*if(projectReport!=null){
				projectReport=rp.getProjectReport(clientdet.get(0).getClient_id());

				System.out.println("Project rep size  : "+projectReport.size());
			}*/
			
			
			
			projectReport=rp.getProjectReport1();
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
