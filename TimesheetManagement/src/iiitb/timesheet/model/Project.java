package iiitb.timesheet.model;

import java.util.Date;

public class Project {

	private int manager_id;
	private int project_num;
	private String project_name;
	private String description;
	private String startdate;
	private String enddate;
	private String cost_per_hour;
	private int client_id;
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getProject_num() {
		return project_num;
	}
	public void setProject_num(int project_num) {
		this.project_num = project_num;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCost_per_hour() {
		return cost_per_hour;
	}
	public void setCost_per_hour(String cost_per_hour) {
		this.cost_per_hour = cost_per_hour;
	}
	
	
	
	
	
}
