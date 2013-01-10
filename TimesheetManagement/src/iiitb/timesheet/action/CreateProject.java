package iiitb.timesheet.action;

import iiitb.timesheet.model.Project;
import iiitb.timesheet.service.CreateProjectService;
import iiitb.timesheet.service.ManagerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class CreateProject extends ActionSupport{

	private int ProjectNumber;
	private String ProjectName;
	private String ProjectDesc;
	private String StartDate;
	private String EndDate;
	private String Cost;
	private String client;
	ArrayList<String> clients=new ArrayList<String>();


	public ArrayList<String> getClients() {
		return clients;
	}

	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
	}


	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getProjectNumber() {
		return ProjectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		ProjectNumber = projectNumber;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectDesc() {
		return ProjectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		ProjectDesc = projectDesc;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}

	public String execute()
	{
		ManagerService ms=new ManagerService();
		System.out.println("Project :  ---> "+ProjectNumber);
		System.out.println(ProjectName);
		System.out.println(ProjectDesc);
		System.out.println(getDate(StartDate));
		System.out.println(getDate(EndDate));
		System.out.println(Cost);


		System.out.println("suhas sss-> "+getDt(getDate(StartDate)));

		Project project =new Project();
		CreateProjectService cp=new CreateProjectService();

		// manager id to be retrieved from the user

		project.setManager_id(1);
		project.setProject_num(ProjectNumber);
		project.setProject_name(ProjectName);
		project.setDescription(ProjectDesc);
		project.setStartdate(getDate(StartDate));
		project.setEnddate(getDate(EndDate));
		project.setCost_per_hour(Cost);
		System.out.println("- >>>> suhas "+cp.getClientID(client));
		project.setClient_id(cp.getClientID(client));


		/*try {
			int i=cp.addProject1(project);

			System.out.println(i);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clients=ms.getClients();

		return SUCCESS;*/


		Boolean val = CreateProjectService.checkForDuplicateProj(project);
		int i = 0;
		if(val==true) {
			try {
				i=cp.addProject1(project);

				System.out.println(i);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			if(i>0){
			
			clients=ms.getClients();
			addActionMessage(getText("Project added successfully ."));
			return SUCCESS;
			}else{
				addActionError(getText("Error in adding Project. Try Again."));
				return "error";
			}
		} else {
			addActionError(getText("Project already exists!!"));
			return "duplicate";
		}


	}


	public static String getDate(String date){


		String formattedDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStr = formatter.parse(date);
			formattedDate = formatter.format(dateStr);
			//System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
			Date date1 = formatter.parse(formattedDate);

			//System.out.println(date1);

			formatter = new SimpleDateFormat("dd-MM-yyyy");
			formattedDate = formatter.format(date1);
			//System.out.println("dd-MM-yyyy date is ==>"+formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formattedDate;
	}


	public static Date getDt(String date){

		Date dateStr = null ;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			dateStr = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateStr; 
	}



}
