package iiitb.timesheet.service;

import iiitb.timesheet.model.AssignedEmployees;
import iiitb.timesheet.model.Assignment;
import iiitb.timesheet.util.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssignmentService {

	public static String findTaskName(String selectionModifier) {
		
		Assignment assign = new Assignment();
		java.sql.ResultSet resultSet = null;
		String query = "select task_name from assignment "+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			while (resultSet.next()) {
				String taskname = resultSet.getString("task_name");
				assign.setTask_name(taskname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return assign.getTask_name();
	}

	public static int findProjectID(String selectionModifier) {
		
		Assignment assign = new Assignment();
		java.sql.ResultSet resultSet = null;
		String query = "select pid from assignment "+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				assign.setPid(pid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return assign.getPid();
	}
	
	public static ArrayList<Assignment> findEmployeeID(String selectionModifier) {
		
		ArrayList<Assignment> empid = new ArrayList<Assignment>();
		Assignment assign = new Assignment();
		java.sql.ResultSet resultSet = null;
		String query = "select emp_id from assignment "+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			System.out.println("inside while in find employee id ----------- AssignmentService.java");
			while (resultSet.next()) {
				int employeeid = resultSet.getInt("emp_id");
				System.out.println("employee id :" + employeeid);
				assign.setEmp_id(employeeid);
				
				empid.add(assign);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		for(int i=0;i<empid.size();i++){
			System.out.println("other employee id are :"+empid.get(i).getEmp_id());
		}
		return empid;
	}
	
	
	
	
public static ArrayList<AssignedEmployees> getOtherEmp(int pid) {
		
		ArrayList<AssignedEmployees> empid = new ArrayList<AssignedEmployees>();
		
		java.sql.ResultSet resultSet = null;
		String query = "select firstname,lastname,e.emp_id from employee e, assignment a where e.emp_id = a.emp_id and a.pid ="+"'"+pid+"';";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			System.out.println("inside while in find employee id ----------- AssignmentService.java");
			while (resultSet.next()) {
				AssignedEmployees ae=new AssignedEmployees();
				ae.setEmp_id(resultSet.getInt("emp_id"));
				ae.setEmp_name(resultSet.getString("firstname")+" "+resultSet.getString("lastname"));
				empid.add(ae);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		
		return empid;
	}


}
