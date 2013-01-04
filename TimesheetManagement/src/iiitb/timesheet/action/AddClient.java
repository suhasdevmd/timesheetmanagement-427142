package iiitb.timesheet.action;

import iiitb.timesheet.service.AddClientService;

import com.opensymphony.xwork2.ActionSupport;

public class AddClient extends ActionSupport{

	private String ClientName;
	private String City;

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	
	
	public String  execute(){
		
		System.out.println(ClientName);
		System.out.println(City);
		
		
		AddClientService acs=new AddClientService();
		int i=acs.addClient(ClientName);
		
		
		return SUCCESS;
	}
	
}
