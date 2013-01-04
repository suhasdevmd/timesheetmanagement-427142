package iiitb.timesheet.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Testing {

	/**
	 * @param args
	 */

	public static String getDate(String date){


		String formattedDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStr = formatter.parse(date);
			formattedDate = formatter.format(dateStr);
			System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
			Date date1 = formatter.parse(formattedDate);

			System.out.println(date1);

			formatter = new SimpleDateFormat("dd-MM-yyyy");
			formattedDate = formatter.format(date1);
			System.out.println("dd-MM-yyyy date is ==>"+formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formattedDate;
	}



	public static String[] getCredentials(String lastname,int phone_number){

		String credentials[]=new String[2];

		credentials[0]=lastname;
		credentials[1]=lastname+"@"+phone_number;


		return credentials;
	}

	public static String[] getCredentials1(String name){

		String credentials[]=new String[2];
		int randomInt = 0;
	
		credentials[0]=name;
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1000; ++idx){
	      randomInt = randomGenerator.nextInt(10000);
	    }
	    
		credentials[1]=name+"@"+randomInt;


		return credentials;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String strDate = "2008-10-14";
		String mydate="2012-12-20T00:00:00+05:30";
		mydate=mydate.substring(0,10);

		String sd=getDate(mydate);

		System.out.println(sd);
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStr = formatter.parse(mydate);
		String formattedDate = formatter.format(dateStr);
		System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
		Date date1 = formatter.parse(formattedDate);

		formatter = new SimpleDateFormat("dd-MM-yyyy");
		formattedDate = formatter.format(date1);
		System.out.println("dd-MM-yyyy date is ==>"+formattedDate);*/



		//String credentials[]=getCredentials("suhas",232472);
		String credentials[]=getCredentials1("suhas");

		System.out.println("username : "+credentials[0]);
		System.out.println("password : "+credentials[1]);


	}

}
