package iiitb.timesheet.action;

import iiitb.timesheet.model.Client;
import iiitb.timesheet.service.AddClientService;

import com.opensymphony.xwork2.ActionSupport;

public class AddClient extends ActionSupport{

	private String ClientName;
	private String City;
	private String email;
	private long phone;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}




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

		/*System.out.println(ClientName);
		System.out.println(City);
		System.out.println(email);
		System.out.println(phone);


		AddClientService acs=new AddClientService();
		int i=acs.addClient(ClientName,email,phone,City);


		return SUCCESS;*/



		Client client = new Client();
		client.setCity(City);
		client.setClient_name(ClientName);
		client.setPhone_num(phone);
		client.setEmail(email);
		System.out.println(ClientName);
		System.out.println(City);
		System.out.println(email);
		System.out.println(phone);

		AddClientService acs=new AddClientService();
		Boolean val = AddClientService.checkForDuplicateClient(client);
		if(val==true) {
			int i=acs.addClient(ClientName,email,phone,City);
			if(i>0){
				addActionMessage(getText("Client successfully added."));
				return SUCCESS;
			}else{
				addActionError(getText("Error adding client. Please try again."));
				return "duplicate";
			}
		} else  {
			addActionError(getText("Client already exists!!"));
			return "duplicate";
		}
	
}

}
