package iiitb.timesheet.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Logout extends ActionSupport{
       
       private static final long serialVersionUID = 1L;

       public String execute() throws Exception {
               Map session = ActionContext.getContext().getSession();
               session.remove("login"); 
               
               System.out.println("inside logout");
               
               return SUCCESS;
       }
}