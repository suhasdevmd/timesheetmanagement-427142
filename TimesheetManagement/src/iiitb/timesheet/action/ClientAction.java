package iiitb.timesheet.action;

import iiitb.timesheet.model.Client;
import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.service.ReportService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
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
		
		Map session=ActionContext.getContext().getSession();
		ArrayList<Client> clientdet=(ArrayList<Client>)session.get("ClientDetails");
		
		ReportService rp=new ReportService();
		projectReport=rp.getProjectReport(clientdet.get(0).getClient_id());
		
		
		
		
		
		
		System.out.println("Project rep size suhas : "+projectReport.size());
		//val="Project";
		setCurrentDate(new Date());
		
		return SUCCESS;
	}
	
	
}
