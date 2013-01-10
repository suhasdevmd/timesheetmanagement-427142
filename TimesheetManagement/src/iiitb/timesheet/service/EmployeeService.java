package iiitb.timesheet.service;

import iiitb.timesheet.model.Employee;
import iiitb.timesheet.util.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeService {

	public int update(Employee employee) {
		System.out.println("hello \n\n");
		String updateSQL = 
			"update employee "
			+ "set firstname = '" + employee.getFirstname() + "', lastname = '" + employee.getLastname() + 
			"', email = '" + employee.getEmail() + "', phone_num = " + employee.getPhone_num() + 
			", join_date = '" + employee.getJoin_date() + 
			"', role_id = " + getId(employee.getRole_name()) + " " + 
			"where emp_id = " + employee.getEmp_id();
		return DB.update(updateSQL);
	}


	public int insert(Employee employee) {
		//System.out.println("hello \n\n");

		String insertSQL = "insert into employee "
			+ "(firstname, lastname, email, phone_num, join_date, role_id) " + 
			"values('" + employee.getFirstname()
			+ "', '" + employee.getLastname() + "', '" + employee.getEmail() + "', " + employee.getPhone_num() + 
			", '" + employee.getJoin_date() + "', " + getId(employee.getRole_name()) + ");";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}

	public int insertIntoUserAcc(Employee employee) {
		//System.out.println("hello \n\n");

		int status;
		String insertSQL = "insert into useraccount "
			+ "(emp_id, role_id, username, password) " + 
			"values(" + employee.getEmp_id()
			+ ", " + getId(employee.getRole_name()) + ", '" + employee.getFirstname() +
			"', '" + getCredentials(employee.getLastname(),employee.getPhone_num()) + "');";
		System.out.println(insertSQL);
		status=DB.update(insertSQL);



		// send email

		return status;
	}


	public static int getId(String name) {


		ResultSet rs=null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DB.getConnection();
			java.sql.Statement statement = connection.createStatement();
			String sql="select role_id from role where role_name = '"+name+"'";

			rs=statement.executeQuery(sql);	
			if(rs.next()){

				return rs.getInt(1);

			}else{

			}
			rs.close();

			if (statement != null) 
				statement.close();
			connection.close();


		} catch (Exception e) {
			System.out.println(" Exception occurred	exception:Exception" + e);
			return 0;
		} 





		return 0;


	}

	public static ArrayList<Employee> getEmployees(String selectionModifier) {
		ArrayList<Employee> selection = new ArrayList<Employee>();
		ResultSet resultSet = null;
		//String query = "select emp_id, firstname, lastname, email, phone_num, join_date, " +
		//	"manager_id, role_id" +
		//"from employee " + selectionModifier;


		String query= "select * from employee "+selectionModifier;

		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {


			while (resultSet.next()) {
				Employee employee = getEmployeeFromResultSet(resultSet);
				//System.out.println("----> "+resultSet.getInt("emp_id"));
				selection.add(employee);
			}
		} catch (SQLException e) {
			//MyLog.myCatch("Employee.java", 43, e);
			e.printStackTrace();
		}catch (Exception e) {

			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static Employee getEmployeeFromResultSet(ResultSet resultSet) {
		Employee employee = new Employee();
		try {
			employee.setEmp_id(resultSet.getInt("emp_id"));
			employee.setFirstname(resultSet.getString("firstname"));
			employee.setLastname(resultSet.getString("lastname"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPhone_num(resultSet.getLong("phone_num"));
			employee.setJoin_date(resultSet.getString("join_date"));
			employee.setRole_name(getRoleName(resultSet.getInt("role_id")));
			employee.setManager_id(resultSet.getInt("manager_id"));
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;

	}


	public static Employee getEmployee(String selectionModifier) {
		ResultSet resultSet = null;
		String query= "select * from employee "+selectionModifier;

		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		//System.out.println("hello \n\n");
		try {
			if (resultSet.next()) {
				//System.out.println(resultSet.getInt("emp_id"));
				//System.out.println(resultSet.getString("firstname"));
				Employee employee = getEmployeeFromResultSet(resultSet);
				DB.close(resultSet);
				DB.close(connection);
				return employee;
			}
		} catch (SQLException e) {
			//MyLog.myCatch("Employee.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}


	public static String getDate(String date){


		String formattedDate = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStr = null;
		try {
			dateStr = formatter.parse(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedDate = formatter.format(dateStr);
		//System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
		Date date1 = null;
		try {
			date1 = formatter.parse(formattedDate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(date1);

		formatter = new SimpleDateFormat("dd-MM-yyyy");
		formattedDate = formatter.format(date1);
		//System.out.println("dd-MM-yyyy date is ==>"+formattedDate);

		return formattedDate;
	}
	
	
	
	
	
	public static String getCredentials(String lastname,long phone_number){

		String credentials = lastname;
		String phno = String.valueOf(phone_number);
		credentials = credentials.concat("@");
		credentials = credentials.concat(phno);
		/*credentials[0]=lastname;
		credentials[1]=lastname+"@"+phone_number;*/
		System.out.println("credentials :" +credentials);


		return credentials;
	}



	public static String getRoleName(int role_id){

		ResultSet rs=null;
		String role_name="";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DB.getConnection();
			java.sql.Statement statement = connection.createStatement();
			String sql="select role_name from role where role_id = '"+role_id+"'";

			rs=statement.executeQuery(sql);	
			if(rs.next()){

				role_name=rs.getString("role_name");

			}else{

			}
			rs.close();

			if (statement != null) 
				statement.close();
			connection.close();


		} catch (Exception e) {
			System.out.println(" Exception occurred	exception:Exception" + e);
		} 





		return role_name;

	}




	public static int findManagerID(String selectionModifier) {

		Employee emp = new Employee();
		java.sql.ResultSet resultSet = null;
		String query = "select manager_id from Employee "+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				int managerID = resultSet.getInt("manager_id");
				emp.setManager_id(managerID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return emp.getManager_id();
	}

	public static ArrayList<Employee> findEmployeeDetails(String selectionModifier) {

		Employee emp = new Employee();
		ArrayList<Employee> empArrList = new ArrayList<Employee>();
		java.sql.ResultSet resultSet = null;
		String query = "select * from Employee "+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				int empid = resultSet.getInt("emp_id");
				emp.setEmp_id(empid);

				String firstname = resultSet.getString("firstname");
				emp.setFirstname(firstname);

				String lastname = resultSet.getString("lastname");
				emp.setLastname(lastname);

				String email = resultSet.getString("email");
				emp.setEmail(email);

				long phno = resultSet.getLong("phone_num");
				emp.setPhone_num(phno);

				String joindate = resultSet.getString("join_date");
				emp.setJoin_date(joindate);

				int roleid = resultSet.getInt("role_id");
				//System.out.println("roleID = "+roleid);
				if(roleid == 1)
					emp.setRole_name("Admin");
				else if(roleid == 2)
					emp.setRole_name("Manager");
				else if(roleid == 3)
					emp.setRole_name("Team_Member");
				else
					emp.setRole_name("Client");

				int managerID = resultSet.getInt("manager_id");
				emp.setManager_id(managerID);

				empArrList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return empArrList;
	}




	public static boolean checkForDuplicateEmp(Employee employee)  {

		ResultSet resultSet = null;
		String query= "select emp_id from employee "  +  " where firstname= '" + employee.getFirstname() + "' and lastname= '" + employee.getLastname() + "' and email= '" + employee.getEmail()
		+ "' and phone_num= " + employee.getPhone_num() + " and join_date= '" + employee.getJoin_date() + "' and role_id= " + getId(employee.getRole_name());
		System.out.println(query);
		//System.out.println(employee.getFirstname());
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet!=null && resultSet.first()) {
				DB.close(resultSet);
				DB.close(connection);
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return true;	


	}





}
