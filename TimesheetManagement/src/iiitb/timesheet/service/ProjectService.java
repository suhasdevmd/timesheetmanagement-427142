package iiitb.timesheet.service;

import iiitb.timesheet.model.Project;
import iiitb.timesheet.util.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectService {

	public static String findProjectName(String selectionModifier) {
		
		java.sql.ResultSet resultSet = null;
		String query = "select project_name from project " + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			if (resultSet.next()) {
				Project project = new Project();	
				String projectname = resultSet.getString("project_name");
				project.setProject_name(projectname);
				
				DB.close(resultSet);
				DB.close(connection);
				
				System.out.println("=====IN Project.java - findProjectName=====");
				System.out.println("Project Name : "+project.getProject_name());
				System.out.println("===========================================");
				
				return project.getProject_name();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}
	

	public static ArrayList<Project> findProjectDetails(String selectionModifier,int empid) {
		
		ArrayList<Project> projectlist = new ArrayList<Project>();
		java.sql.ResultSet resultSet = null;
		String query = "select * from project " + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			if (resultSet.next()) {
				Project project = new Project();	
				
				int pnum = resultSet.getInt("project_num");
				project.setProject_num(pnum);
				System.out.println("project number: "+project.getProject_num());
				
				String projectname = resultSet.getString("project_name");
				project.setProject_name(projectname);
				System.out.println("project name: "+project.getProject_name());
				
				String description = resultSet.getString("description");
				project.setDescription(description);
				System.out.println("Description: "+project.getDescription());
				
				String sdate = resultSet.getString("startdate");
				project.setStartdate(sdate);
				System.out.println("start date: "+project.getStartdate());
				
				String edate = resultSet.getString("enddate");
				project.setEnddate(edate);
				System.out.println("End date: "+project.getEnddate());
				
				projectlist.add(project);
				
				DB.close(resultSet);
				DB.close(connection);
				
				return projectlist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	
}
