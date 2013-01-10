package iiitb.timesheet.service;

import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.model.TimesheetEmployee;
import iiitb.timesheet.util.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class TimeSheetService {

	public static int findTimeSheetID(String selectionModifier) {

		Timesheet ts = new Timesheet();
		java.sql.ResultSet resultSet = null;
		String query = "select timesheet_id from timesheet " + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				int timeSheetID = resultSet.getInt("timesheet_id");
				ts.setTimesheet_id(timeSheetID);
				/*System.out.println("in while of timesheet.java");
				System.out.println("timesheet id = "+ts.timeSheetID);*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return ts.getTimesheet_id();
	}

	public static ArrayList<TimesheetEmployee> findTimeSheet(String selectionModifier) {

		ArrayList<TimesheetEmployee> timesheetemployee = new ArrayList<TimesheetEmployee>();
		java.sql.ResultSet resultSet = null;
		String query = "select t.project_num,t.task_name,t.work_date,t.no_of_hours,a.status,p.project_name from approval a,timesheet t,project p" + selectionModifier;
		System.out.println(query);
		
		
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			//timesheetemployee.clear();
			while (resultSet.next()) {				
				TimesheetEmployee tse = new TimesheetEmployee();
				int projectnum = resultSet.getInt("project_num");
				tse.setProject_num(projectnum);
				//System.out.println(projectnum);
				
				String pname = resultSet.getString("project_name");
				tse.setProject_name(pname);
				//System.out.println(pname);
				
				String taskname = resultSet.getString("task_name");
				tse.setTask_name(taskname);
				//System.out.println(taskname);
				
				String workdate = resultSet.getString("work_date");
				tse.setWork_date(workdate);
				//System.out.println(workdate);
				
				float hrs = resultSet.getFloat("no_of_hours");
				tse.setNo_of_hours(hrs);
				//System.out.println(hrs);
				
				String status = resultSet.getString("status");
				tse.setStatus(status);
				//System.out.println(status);
				
				//System.out.println("++++++===================+++++++++++");
				
				timesheetemployee.add(tse);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		/*System.out.println("size = "+timesheetemployee.size());
		System.out.println("======================================================");
		for(int i =0;i<timesheetemployee.size();i++){
			System.out.println(timesheetemployee.get(i).getProject_num());
			System.out.println(timesheetemployee.get(i).getProject_name());
			System.out.println(timesheetemployee.get(i).getTask_name());
			System.out.println(timesheetemployee.get(i).getWork_date());
			System.out.println(timesheetemployee.get(i).getNo_of_hours());
			System.out.println("======================================================");
		}*/
		return timesheetemployee;
	}

	
	
	public static int findEmployeeID(String selectionModifier) {

        Timesheet ts = new Timesheet();
        java.sql.ResultSet resultSet = null;
        String query = "select emp_id from timesheet " + selectionModifier;
        java.sql.Connection connection = DB.getConnection();
        resultSet = DB.readFromDB(query, connection);

        try {
                while (resultSet.next()) {
                        int empID = resultSet.getInt("emp_id");
                        ts.setEmp_id(empID);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        DB.close(resultSet);
        DB.close(connection);

        return ts.getEmp_id();
}
	
	

}
