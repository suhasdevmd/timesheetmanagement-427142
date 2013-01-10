package iiitb.timesheet.action;

import iiitb.timesheet.model.Client;
import iiitb.timesheet.model.ProjectReport;
import iiitb.timesheet.model.Report;
import iiitb.timesheet.service.ReportService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExcelDemo extends ActionSupport{

	private ByteArrayInputStream excelStream;
	ArrayList<Report> reports=new ArrayList<Report>();
	ArrayList<ProjectReport> Preports=new ArrayList<ProjectReport>();
	ArrayList<Report> eReports=new ArrayList<Report>();
	private String generate;
	
	
	
	public ArrayList<Report> geteReports() {
		return eReports;
	}

	public void seteReports(ArrayList<Report> eReports) {
		this.eReports = eReports;
	}

	public ArrayList<ProjectReport> getPreports() {
		return Preports;
	}

	public void setPreports(ArrayList<ProjectReport> preports) {
		Preports = preports;
	}

	

	public String getGenerate() {
		return generate;
	}

	public void setGenerate(String generate) {
		this.generate = generate;
	}

	public ArrayList<Report> getReports() {
		return reports;
	}

	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}

	public ByteArrayInputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(ByteArrayInputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String execute(){

		//setContentDisposition("attachment; filename=\"" + "Sample" + ".xls\"");

		System.out.println("--> >>>> LL LL  KK "+generate);
		try{
			if(generate.startsWith("Timesheet")){

				System.out.println("inside timesheet");





				HSSFWorkbook hwb=new HSSFWorkbook();
				HSSFSheet sheet =  hwb.createSheet("Timesheet");

				HSSFRow rowhead1=   sheet.createRow((short)0);
				rowhead1.createCell((short) 0).setCellValue("Timesheet status Report");

				HSSFRow rowhead=   sheet.createRow((short)1);
				rowhead.createCell((short) 0).setCellValue("Work Date");
				rowhead.createCell((short) 1).setCellValue("Employee");
				rowhead.createCell((short) 2).setCellValue("Approver");
				rowhead.createCell((short) 3).setCellValue("Status");



				// retrieve the data to fill in the excel file

				ReportService rp=new ReportService();
				reports=rp.getReports();


				for(int i=0;i<reports.size();i++){
					//////You can repeat this part using for or while to create multiple rows//////
					HSSFRow row = sheet.createRow(i+2);
					row.createCell(0).setCellValue(reports.get(i).getWork_date());
					row.createCell(1).setCellValue(reports.get(i).getEmp_name());
					row.createCell(2).setCellValue(reports.get(i).getApprover());
					row.createCell(3).setCellValue(reports.get(i).getStatus());
				}


				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hwb.write(baos);
				excelStream = new ByteArrayInputStream(baos.toByteArray());
			}
			else if(generate.startsWith("Employee")){

				
				HSSFWorkbook hwb=new HSSFWorkbook();
				HSSFSheet sheet =  hwb.createSheet("Timesheet");

				HSSFRow rowhead1=   sheet.createRow((short)0);
				rowhead1.createCell((short) 0).setCellValue("Timesheet status Report");

				HSSFRow rowhead=   sheet.createRow((short)1);
				rowhead.createCell((short) 0).setCellValue("Work Date");
				rowhead.createCell((short) 1).setCellValue("Employee");
				rowhead.createCell((short) 2).setCellValue("Approver");
				rowhead.createCell((short) 3).setCellValue("Status");



				// retrieve the data to fill in the excel file

				ReportService rp=new ReportService();
				reports=rp.getReports();


				for(int i=0;i<reports.size();i++){
					//////You can repeat this part using for or while to create multiple rows//////
					HSSFRow row = sheet.createRow(i+2);
					row.createCell(0).setCellValue(reports.get(i).getWork_date());
					row.createCell(1).setCellValue(reports.get(i).getEmp_name());
					row.createCell(2).setCellValue(reports.get(i).getApprover());
					row.createCell(3).setCellValue(reports.get(i).getStatus());
				}


				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hwb.write(baos);
				excelStream = new ByteArrayInputStream(baos.toByteArray());
				
				
				
			}else if(generate.startsWith("Project")){

				
				
				HSSFWorkbook hwb=new HSSFWorkbook();
				HSSFSheet sheet =  hwb.createSheet("Project");

				HSSFRow rowhead1=   sheet.createRow((short)0);
				rowhead1.createCell((short) 0).setCellValue("Project Allocation Report");

				HSSFRow rowhead=   sheet.createRow((short)1);
				rowhead.createCell((short) 0).setCellValue("Project Number");
				rowhead.createCell((short) 1).setCellValue("Project Name");
				rowhead.createCell((short) 2).setCellValue("Description");
				rowhead.createCell((short) 3).setCellValue("Start Date");
				rowhead.createCell((short) 4).setCellValue("End Date");
				rowhead.createCell((short) 5).setCellValue("First Name");
				rowhead.createCell((short) 6).setCellValue("Last Name");
				Map session=ActionContext.getContext().getSession();
				ArrayList<Client> clientdet=(ArrayList<Client>)session.get("ClientDetails");


				// retrieve the data to fill in the excel file

				ReportService rp=new ReportService();
				
				if(clientdet!=null){
				
				Preports=rp.getProjectReport(clientdet.get(0).getClient_id());
				}
				else{
					Preports=rp.getProjectReport1();
				}
					

				for(int i=0;i<Preports.size();i++){
					//////You can repeat this part using for or while to create multiple rows//////
					HSSFRow row = sheet.createRow(i+2);
					row.createCell(0).setCellValue(Preports.get(i).getProject_num());
					row.createCell(1).setCellValue(Preports.get(i).getProject_name());
					row.createCell(2).setCellValue(Preports.get(i).getDescription());
					row.createCell(3).setCellValue(Preports.get(i).getStartdate());
					row.createCell(4).setCellValue(Preports.get(i).getEnddate());
					row.createCell(5).setCellValue(Preports.get(i).getFirstname());
					row.createCell(6).setCellValue(Preports.get(i).getLastname());
				}


				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hwb.write(baos);
				excelStream = new ByteArrayInputStream(baos.toByteArray());
				
			}



		}catch(Exception e){
			System.out.println(e.getMessage());
		}


		return SUCCESS;
	}


}
