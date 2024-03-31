package com.lalit.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lalit.Garages.WorkLog;
import com.lalit.GaragesDao.WorkLogDao;

@Controller
public class HomeWorkLogController {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
	
	WorkLog workLog=(WorkLog) context.getBean("workLog");
	WorkLogDao workLogDao=(WorkLogDao) context.getBean("workLogDao");
	
	
	
		@RequestMapping("/addWork")
	
		public String addWork()
		{
			return"addWork";
			
		}
		
	
		@RequestMapping(path="/afterAddWorkLog",method=RequestMethod.POST)
		public String afterAddWorkLog(HttpServletRequest request)
		{
				
		System.out.println("hi");
		String VehicleNo=request.getParameter("VehicleNo");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String garageContact=request.getParameter("garageContact");
		String dueDate=request.getParameter("dueDate");
		//set the value
		workLog.setVehicleNo(VehicleNo);
		workLog.setTitle(title);
		workLog.setDescription(description);
		workLog.setDate(date);
		workLog.setEmail(email);	
		workLog.setContact(contact);
		workLog.setAddress(address);
		workLog.setGarageContact(garageContact);
		workLog.setDueDate(dueDate);
		
		 
		// if else condition for add the data
		int p=workLogDao.addWorkLog(workLog);
		
		if(p!=0)
		{
			return "success";
			
		}
		else
		{
			return "error";
			
			
		}
		
		
	}
		
		

		
				
		
		
		
	}


	


	

	

