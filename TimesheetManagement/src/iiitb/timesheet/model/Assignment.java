package iiitb.timesheet.model;

import iiitb.timesheet.util.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Assignment {
	
	private String task_name;
	private int emp_id;
	private int pid;
	private String name;
	
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
