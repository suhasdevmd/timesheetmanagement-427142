package iiitb.timesheet.service;

import iiitb.timesheet.model.Timesheet;
import iiitb.timesheet.util.DB;

import java.sql.SQLException;

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
	
}
